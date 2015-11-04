var fs = require("fs");
var thrift = require("thrift");
var Logger = require("./logservice/LogService");
var ttypes = require("./logservice/LogService_types");

var file = false;

var server = thrift.createServer(Logger, {
  startLogging: function(filename, result) {
    if(!file) {
        // <add filename verification here>
        file = fs.createWriteStream(filename, {flags: 'w'});
        console.log("logging to file: " + filename);
        result(true);
    } else {
        result(false);
    }
  },

  stopLogging: function(result) {
    console.log("stopping logging to file")
    file.end();
    file = false;
    result(true);
  },

  log: function(level, mstime, message, result) {
    // <add check that message is json here>
    jsonmsg = {
        'time': Date.now(),
        'level': level,
        'message': JSON.parse(message)
    };
    message = JSON.stringify(jsonmsg);
    if(file) {
        file.write(message + '\n');
    }
    // console.log(message);
    result(true);
  }
}).on('error', function(err) {
    // handle new errors as they arise
    switch(err.code) {
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
