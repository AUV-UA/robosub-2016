var debug = require("debug")("app");
var fs = require("fs");
var thrift = require("thrift");
var Logger = require("./logservice/LogService");
var ttypes = require("./logservice/LogService_types");

var dir = __dirname;
var file = false;
var fileList = [];
var initTime = 0;


var getHrTimeMs = function() {
  time = process.hrtime();
  return time[0] * 1000 + time[1] / 1000000;
}

var updateLogFileList = function() {
  fileList = fs.readdirSync(dir);
}

var LoggerHandler = {
  setLogDirectory: function(path, result) {
    try {
      process.chdir(path);
    } catch(e) {
    debug("Directory is bad!");
    result(null, false);
    return;
    }
    dir = process.cwd();
    updateLogFileList();
    debug("Directory found!");
    result(null, true);
  },

  getLogFileList: function(result) {
    updateLogFileList();
    result(null, fileList);
  },

  getLogFile: function(filename, result) {
    if (fileList.indexOf(filename) > -1) {
      result(null, fs.readFileSync(dir + '/' + filename));
    } else {
      throw FileNotFound;
    }
  },

  startLogging: function(filename, result) {
    if (!file) {
      file = fs.createWriteStream(dir + '/' + filename, {
        flags: 'w'
      })
        .on('error', function(err) {
          debug("error opening file: " + err);
          file.end();
          file = false;
          result(null, false);
        })
        .on('open', function() {
          debug("logging to file: " + filename);
          initTime = getHrTimeMs();
          updateLogFileList();
          result(null, true);
        });
    } else {
      result(null, false);
    }
  },

  isLogging: function(result) {
    result(null, (file !== false));
  },

  stopLogging: function(result) {
    if (file) {
      debug("stopping logging to file");
      file.end();
      file = false;
    }
    result(null, true);
  },

  log: function(level, message) {
    try {
      message = JSON.parse(message)
    } catch (e) { }
    jsonmsg = {
      'time': getHrTimeMs() - initTime,
      'level': level,
      'message': message
    };
    message = JSON.stringify(jsonmsg);
    if (file) {
      file.write(message + '\n');
    }
  }
};

var server = thrift.createServer(Logger, LoggerHandler).on('error', function(err) {
  // handle new errors as they arise
  switch (err.code) {
    case 'ECONNRESET':
      console.log("Client abruptly disconnected! (ECONNRESET)");
      break;
    default:
      console.log("Unknown error:\n\t" + err);
      break;
  }
});

console.log("Starting server");
server.listen(5001);
