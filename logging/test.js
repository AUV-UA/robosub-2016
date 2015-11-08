var thrift = require('thrift');
var Logger = require('./logservice/LogService');
var ttypes = require('./logservice/LogService_types');

var connection = thrift.createConnection("localhost", 5001);
client = thrift.createClient(Logger, connection);

connection.on('error', function(err) {
  console.log(err);
});

client.getLogFileList(function(err, response) {
  console.log("File list: " + response);
});

client.setLogDirectory('/home/auvua/log', function(err, response) {
  console.log(response);
});

client.startLogging('test.txt', function(err, response) {
  console.log('startLogging(test.txt)');
});

msg = {
  'time': Date.now(),
  'Test message': "does it work?",
  'I think': 42,
  'it does': 3.14159,
  'x': 0
};

x = 0;
setInterval(function() {
  msg['x'] = ++x;
  msg['time'] = Date.now();
  client.log(ttypes.Level.INFO, JSON.stringify(msg), function(err, response) {
    console.log("logging data");
  });
  if (x > 100) {
    client.stopLogging(function(err, response) {
      client.getLogFile('test.txt', function(err, response) {
        console.log("File: " + response);
        connection.end();
        process.exit();
      });
    });
  }
}, 10);
