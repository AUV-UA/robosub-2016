from thrift import Thrift
from thrift.server import TServer
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from visionservice import VisionService
from visionservice.ttypes import *
import time

try:
    transport = TSocket.TSocket('localhost', port=8080)
    transport = TTransport.TBufferedTransport(transport)
    protocol = TBinaryProtocol.TBinaryProtocol(transport)
    client = VisionService.Client(protocol)

    transport.open()

    input = InputSource(ImageSourceType.DEVICE, '')
    filter = Filter(FilterSourceType.RGB, FilterSinkType.BINARY, 'RGB_THRESHOLD', {})

    print "OpenCV version:\n\t" + client.getOpenCVVersion()
    print "Available filters:\n\t" + str(client.getFilterList())
    print "Connected cameras:\n\t" + str(client.getConnectedCameras())
    print "Retrieve image:\n\t" + str(client.getImage(input))
    print "Single filter result:\n\t" + str(client.applyFilter(filter))
    print "Chained filter result:\n\t" + str(client.applyFilterChain([filter, filter]))

    transport.close()

except Thrift.TException, tx:
    print "Error: %s" % (tx.message)
