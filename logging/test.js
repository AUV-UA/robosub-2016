var thrift = require('thrift');
var Logger = require('./logservice/LogService');
var ttypes = require('./logservice/LogService_types');

var connection = thrift.createConnection("localhost", 5001);
client = thrift.createClient(Logger, connection);

connection.on('error', function(err) {
  assert(false, err);
});


client.startLogging('test.txt', function(err, response) {
  console.log('startLogging(test.txt)');
});

msg = {
    'Test message': "does it work?",
    'I think': 42,
    'it does': 3.14159,
    'x': 0
};

x = 0;
setInterval(function() {
    msg['x'] = ++x;
    client.log(ttypes.Level.INFO, 0, JSON.stringify(msg), function(err, response) {
      console.log("logging data");
    });
    if(x > 1000) {
        connection.end();
        process.exit();
    }
}, 10);
