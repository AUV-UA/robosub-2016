/**
 * VisionService
 * Basic vision daemon for applying filters and filter chains on arbitrary
 * image sources.
 */

namespace java org.auvua.visionservice
namespace py visionservice

const string version = "0.1.0"


/**
 * Enumerations
 */
enum ImageSourceType {
    IMAGE = 0   // static image file (png, jpg, bmp)
    VIDEO = 1   // static video file (avi, mp4)
    DEVICE = 2  // v4l2 or uvc compatible device (/dev/video0)
    STREAM = 3  // arbitrary video stream from ffmpeg or libav
}

enum FilterSourceType {
    RGB = 0     // Red/Green/Blue
    BGR = 1     // Blue/Green/Red
    HSV = 2     // Hue/Saturation/Value
    HSL = 3     // Hue/Saturation/Lightness
    BINARY = 4  // Monochrome
}

enum FilterSinkType {
    RGB = 0
    BGR = 1
    HSV = 2
    HSL = 3
    BINARY = 4
    MAP = 5
}


/**
 * Exceptions
 */
exception SourceNotFound {
    1: string path
}


/**
 * Structures
 */
struct InputSource {
    1: required ImageSourceType source
    2: required string path
}

struct Output {
    1: optional string imagePath
    2: optional map<string, double> data
    3: optional double computeTime
}

struct Filter {
    1: required FilterSourceType sourceType
    2: required FilterSinkType sinkType
    3: required string filter
    4: required map<string, double> params
}

struct Resolution {
    1: required i32 horizontal
    2: required i32 vertical
}

struct Camera {
    1: required string deviceName
    10: optional Resolution resolution
}


/**
 * Services
 */
service VisionService {
    string getOpenCVVersion()
    list<Camera> getConnectedCameras()
    list<string> getFilterList()
    Output getImage(1: required InputSource source) throws (1: SourceNotFound snf)
    Output getScaledImage(1: required InputSource source, 2: required Resolution resolution) throws (1: SourceNotFound snf)
    Output applyFilter(1: required Filter filter) throws (1: SourceNotFound snf)
    Output applyFilterChain(1: required list<Filter> filters) throws (1: SourceNotFound snf)
}
