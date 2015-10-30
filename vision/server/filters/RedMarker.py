from visionservice.ttypes import *
import cv2

class RedMarker:
    inputTypes = [
        FilterSourceType.RGB,
        FilterSourceType.BGR
    ]
    outputTypes = [
        FilterSinkType.MAP
    ]
    paramList = ['rMin', 'rMax', 'gMin', 'gMax', 'bMin', 'bMax']

    def __init__(self):
        self.params = {
            'rMin': 0.0,
            'rMax': 255.0,
            'gMin': 0.0,
            'gMax': 255.0,
            'bMin': 0.0,
            'bMax': 255.0
        }
        self.inputType = FilterSourceType.RGB
        self.outputType = FilterSinkType.BINARY

    def run(self, img):
        lower = (self.params['rMin'],
                 self.params['gMin'],
                 self.params['bMin'])
        upper = (self.params['rMax'],
                 self.params['gMax'],
                 self.params['bMax'])

        filtered = cv2.inRange(img, lower, upper)
        avg_center = (-1, -1)
        moms = cv2.moments(filtered)
        size = moms['m00'] / 100

        res = Output(data={})

        if size != 0:
            avg_X = int(moms['m10'] / moms['m00'])
            avg_Y = int(moms['m01'] / moms['m00'])

            res.data['buoy_visible'] = True
            res.data['x_position'] = avg_X
            res.data['y_position'] = avg_Y
            res.data['size'] = size

        return res

if __name__=='__main__':
    img = cv2.imread('filters/lena.png')
    thresh = RedMarker()
    thresh.params['rMin'] = 100.0
    thresh.params['rMax'] = 200.0
    res = thresh.run(img)

    print res
    cv2.waitKey(0)
    cv2.destroyAllWindows()
