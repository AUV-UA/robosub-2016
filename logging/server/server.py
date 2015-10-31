from logservice import LogService
from logservice.ttypes import *
from thrift.server import TServer
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

port = 5001

class LogServiceHandler:
    def __init__(self):
        pass

    def startLogging(self, filename):
        pass

    def stopLogging(self):
        pass

    def log(self, level, msTime, message):
        pass

logHandler = LogServiceHandler()
processor = LogService.Processor(logHandler)
transport = TSocket.TServerSocket(port=port)
tfactory = TTransport.TBufferedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()

server = TServer.TThreadedServer(processor, transport, tfactory, pfactory)

print 'Logging server started on port ' + str(port)
server.serve()
print 'Done.'
