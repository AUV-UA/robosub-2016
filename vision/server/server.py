from visionservice import VisionService
from visionservice.ttypes import *
from thrift.server import TServer
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
import cv2

class VisionServiceHandler:
    def __init__(self):
        pass

    def getOpenCVVersion(self):
        return cv2.__version__

    def applyFilter(self, filter):
        print "Applying filter " + FilterType._VALUES_TO_NAMES[filter.filter]
        res = Output('', {})
        return res

    def applyFilterChain(self, filters):
        res = Output('', {})
        return res

visionHandler = VisionServiceHandler()
processor = VisionService.Processor(visionHandler)
transport = TSocket.TServerSocket(port=8080)
tfactory = TTransport.TBufferedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()

server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)

print 'Vision server started.'
server.serve()
print 'Done.'
