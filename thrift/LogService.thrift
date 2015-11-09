/**
 * LogService
 * Basic vision daemon for applying logging JSON messages.
 */

namespace java org.auvua.logservice
namespace py logservice

/**
 * Enumerations
 */
enum Level {
    DEBUG = 0
    INFO = 1
    WARNING = 2
    ERROR = 3
    FATAL = 4
}


/**
 * Exceptions
 */
exception FileNotFound { }


/**
 * Structures
 */


/**
 * Services
 */
service LogService {
    bool setLogDirectory(1: required string path)
    list<string> getLogFileList()
    string getLogFile(1: required string filename) throws (1: FileNotFound err)
    bool startLogging(1: required string filename)
    bool isLogging()
    bool stopLogging()
    oneway void log(1: required Level level, 2: required string message)
}
