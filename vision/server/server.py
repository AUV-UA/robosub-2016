from visionservice import VisionService
from visionservice.ttypes import *
from thrift.server import TServer
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
import filters
import time
import json
import os
import cv2

filterMap = {}
# There's probably a better way to import the filters dynamically
for m in os.listdir("./filters" ):
    if m.endswith( ".py" ) and m != "__init__.py":
        filtername = m[:-3]
        mod = __import__("filters." + filtername)
        filterMap[filtername] = getattr(getattr(mod, filtername), filtername)

class VisionServiceHandler:

    def __init__(self):
        pass

    def getOpenCVVersion(self):
        return cv2.__version__

    def getConnectedCameras(self):
        return []

    def getFilterList(self):
        return filterMap.keys()

    def getImage(self, source):
        t_init = time.time()
        time.sleep(0.25)
        res = Output(imagePath='', data={}, computeTime=float(time.time()-t_init))
        return res

    def getScaledImage(self, source, resolution):
        return Output('', {})

    def applyFilter(self, filter):
        return Output('', {})

    def applyFilterChain(self, filters):
        return Output('', {})

visionHandler = VisionServiceHandler()
processor = VisionService.Processor(visionHandler)
transport = TSocket.TServerSocket(port=8080)
tfactory = TTransport.TBufferedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()

server = TServer.TThreadedServer(processor, transport, tfactory, pfactory)

print 'Vision server started.'
server.serve()
print 'Done.'
