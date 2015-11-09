# robosub-2016
[![Build Status](https://travis-ci.org/AUV-UA/robosub-2016.svg?branch=master)](https://travis-ci.org/AUV-UA/robosub-2016)

2016 AUV software for Danger 'Zona and more.

The software is split into standalone programs, with Apache Thrift used for both message passing and remote function calls.
* [Remote Interface](#remote-interface): Web-based user interface for controlling vehicles, analyzing log data, and setting up missions and vision filters.
* [Agent](#agent): Responsible for controlling the vehicle autonomously - parses and runs missions and tasks.
* [Vehicle Abstraction Layer](#vehicle-abstraction-layer): Provides interfaces to various vehicles, testbenches, or simulators, as well as storing the known state of the vehicle and controllers for pose, thrust, and various components.  
* [Vision Service](#vision): Applies vision filter chains on command to video or camera streams or images using OpenCV.
* [Logging Service](#logging): Asynchronously saves JSON formatted messages to disk and provides an interface for retrieving log files.

## Thrift Setup
Start by installing the latest version of [Apache Thrift](https://thrift.apache.org/docs/install/).
Then, navigate to `REPO_DIR/thrift/` and run `gen.sh`. This will generate and install the thrift services in their respective service directories.

## Remote Interface
The GUI, or remote interface (AUVUA-RI) for the vehicle is implemented as a server - specifically, an expressjs app. The related code is located under `/remote`.

Install dependencies first, then start the server:
```
cd remote
npm install
npm start
```

Navigate a browser to point to the target machine's IP at port 3000. If viewing on the machine, the URL would be `localhost:3000`.

Enjoy!

## Agent
work-in-progress

## Vehicle Abstraction Layer
work-in-progress

## Vision
The vision server is implemented in Python and requires OpenCV 2.4/3.0, along with the OpenCV python bindings.

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
Navigate to `REPO_DIR/logging/` and run:
```
npm install
```

Start the logging service:
```
DEBUG=app node index.js
```

To test the service, make sure it is running, then start the tests:
```
npm test
```
