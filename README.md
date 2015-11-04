# robosub-2016
2016 AUV software for Danger 'Zona and more.

The software is split into standalone programs, with Apache Thrift used for both message passing and remote function calls.

## Thrift Setup
Start by installing the latest version of [Apache Thrift](https://thrift.apache.org/docs/install/).
Then, navigate to `INSTALL_DIR/thrift/` and run `gen.sh`. This will generate and install the thrift services in their respective service directories.

## Vision
The vision server is implemented in Python and requires OpenCV 2.X/3.0, along with the OpenCV python bindings.

To run, start the vision server:
```
python server.py
```

Test the server with the test client script:
```
python test.py
```

## Logging
The logging server is implemented in Nodejs. This is the central logging service for all programs - outputs should be redirected as messages to this service if they are important enough to be logged for the end-user.

Set up the logging service by installing node dependencies.
Navigate to `INSTALL_DIR/logging/` and run:
```
npm install
```
