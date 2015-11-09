var test = require('unit.js');
var fs = require('fs');
var thrift = require('thrift');
var Logger = require('./logservice/LogService');
var ttypes = require('./logservice/LogService_types');


var msg = {
  'time': Date.now(),
  'Test message': "does it work?",
  'I think': 42,
  'it does': 3.14159,
  'x': 0
};


var connection = thrift.createConnection("localhost", 5001);
var client = thrift.createClient(Logger, connection);

connection.on('error', function(err) {
  test.assert(err, false);
});

describe('Logging to new file', function() {
  it('don\'t set the log directory to "/should/not/exist"', function(done) {
    client.setLogDirectory('/should/not/exist', function(err, response) {
      test.assert(response === false);
      done();
    });
  });

  it('set the log directory to ' + __dirname, function(done) {
    client.setLogDirectory(__dirname, function(err, response) {
      test.assert(response === true);
      done();
    });
  });

  it('return a non-empty list of files in ' + __dirname, function(done) {
    client.getLogFileList(function(err, response) {
      test.assert(response.length > 0);
      done();
    });
  });

  it('start logging to "test.txt"', function(done) {
    client.startLogging('test.txt', function(err, response) {
      test.assert(response === true);
      done();
    });
  });

  it('don\'t start logging if it already is', function(done) {
    client.startLogging('test.txt', function(err, response) {
      test.assert(response === false);
      done();
    });
  });

  it('is logging when actually logging', function(done) {
    client.isLogging(function(err, response) {
      test.assert(response === true);
      done();
    });
  });

  it('writes out message to log file "' + __dirname + '/test.txt"', function(done) {
    var textmsg = JSON.stringify(msg);
    client.log(ttypes.Level.INFO, textmsg);
    setTimeout(function() {
      var contents = fs.readFileSync(__dirname + '/test.txt');
      var rxmsg = JSON.stringify(JSON.parse(contents)['message']);
      test.assert(rxmsg === textmsg);
      done();
    }, 5);
  });

  it('stop logging if currently logging', function(done) {
    client.stopLogging(function(err, response) {
      test.assert(response === true);
      done();
    });
  });

  it('stop logging when not logging', function(done) {
    client.stopLogging(function(err, response) {
      test.assert(response === true);
      done();
    });
  });

  it('is not logging when not actually logging', function(done) {
    client.isLogging(function(err, response) {
      test.assert(response === false);
      done();
    });
  });

  after(function() {
    try {
      fs.unlinkSync(__dirname + '/test.txt');
    } catch (e) {}
  });
});
