from thrift import Thrift
from thrift.server import TServer
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from visionservice import VisionService
from visionservice.ttypes import *

try:
    transport = TSocket.TSocket('localhost', port=8080)
    transport = TTransport.TBufferedTransport(transport)
    protocol = TBinaryProtocol.TBinaryProtocol(transport)
    client = VisionService.Client(protocol)

    transport.open()

    filter = Filter(FilterSourceType.RGB,
        FilterSinkType.BINARY,
        FilterType.RGB_THRESHOLD,
        {})
    print "OpenCV version: " + client.getOpenCVVersion()
    print "Dummy filter result: " + str(client.applyFilter(filter))

    transport.close()

except Thrift.TException, tx:
    print "Error: %s" % (tx.message)
