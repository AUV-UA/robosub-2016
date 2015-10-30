# robosub-2016

2016 AUV software for Danger 'Zona and more.

## Vision

The vision server is implemented with Apache Thrift and requires OpenCV 2.X, along with the OpenCV python bindings.

To run, start the vision server:
```
python server.py
```

Test the server with the test client script:
```
python test.py
```

If everything is working, the version of OpenCV should be printed along with an empty `Output` filter structure.

  
