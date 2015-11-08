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
    if (fs.statSync(path).isDirectory()) {
      // TODO: check for directory issues
      dir = path;
      updateLogFileList();
      console.log("Directory found!");
      result(null, true);
    } else {
      // TODO: throw an error
      console.log("Directory is bad!");
      result(null, false);
    }
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
      });
      file.on('error', function(err) {
        console.log("error opening file: " + err);
        file.end();
        file = false;
      });
      file.on('open', function() {
        console.log("logging to file: " + filename);
        initTime = getHrTimeMs();
        fileList.push(filename);
      });
    }
    result(null, true);
  },

  stopLogging: function(result) {
    if (file) {
      console.log("stopping logging to file");
      file.end();
      file = false;
    }
    result(null, true);
  },

  log: function(level, message) {
    try {
      message = JSON.parse(message)
    } catch (e) {
    }
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
