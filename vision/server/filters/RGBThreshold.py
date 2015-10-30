from visionservice.ttypes import *
import cv2

class RGBThreshold:
    inputTypes = [
        FilterSourceType.RGB,
        FilterSourceType.BGR
    ]
    outputTypes = [
        FilterSinkType.BINARY
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
        res = cv2.inRange(img, lower, upper)
        return res

if __name__=='__main__':
    img = cv2.imread('filters/lena.png')
    thresh = RGBThreshold()
    thresh.params['rMin'] = 100.0
    thresh.params['rMax'] = 200.0
    res = thresh.run(img)

    cv2.imshow('res', res)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
