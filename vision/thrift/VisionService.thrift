/**
 * VisionService
 * Basic vision daemon for applying filters and filter chains on arbitrary
 * image sources.
 *
 * Missing a lot of important things atm, such as exceptions 
 */

namespace java org.auvua.visionservice
namespace py visionservice

const string version = "0.1.0"

enum ImageSourceType {
    IMAGE = 0,  // static image file (png, jpg, bmp)
    VIDEO = 1,  // static video file (avi, mp4)
    DEVICE = 2, // v4l2 or uvc compatible device (/dev/video0)
    STREAM = 3  // arbitrary video stream from ffmpeg or libav
}

enum FilterSourceType {
    RGB = 0,
    BGR = 1,
    HSV = 2,
    HSL = 3,
    BINARY = 4
}

enum FilterSinkType {
    RGB = 0,
    BGR = 1,
    HSV = 2,
    HSL = 3,
    BINARY = 4,
    MAP = 5
}

enum FilterType {
    RGB_THRESHOLD = 0,
    HSV_THRESHOLD = 1,
    GAUSSIAN_BLUR = 2,
    CANNY_EDGE = 3,
    HOUGH_LINE = 4,
    HOUGH_CIRCLE = 5
}

struct InputSource {
    1: required ImageSourceType source,
    2: required string path
}

struct Output {
    1: optional string imagePath,
    2: optional map<string, double> data
}

struct Filter {
    1: required FilterSourceType sourceType,
    2: required FilterSinkType sinkType,
    3: required FilterType filter,
    4: required map<string, double> params
}

service VisionService {
    string getOpenCVVersion();
    Output applyFilter(1: required Filter filter);
    Output applyFilterChain(1: required list<Filter> filters);
}
