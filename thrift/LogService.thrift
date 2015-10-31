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
    INFO = 0
    WARNING = 1
    SEVERE = 2
}


/**
 * Exceptions
 */


/**
 * Structures
 */


/**
 * Services
 */
service LogService {
    bool startLogging(1: required string filename)
    bool stopLogging()
    bool log(1: required Level level, 2: required i32 msTime, 3: required string message)
}
