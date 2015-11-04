from visionservice.ttypes import *
import cv2

class HSVThreshold:
    inputTypes = [
        FilterSourceType.HSV
    ]
    outputTypes = [
        FilterSinkType.BINARY
    ]
    paramList = ['hMin', 'hMax', 'sMin', 'sMax', 'vMin', 'vMax']

    def __init__(self):
        self.params = {
            'hMin': 0.0,
            'hMax': 255.0,
            'sMin': 0.0,
            'sMax': 255.0,
            'vMin': 0.0,
            'vMax': 255.0
        }
        self.inputType = FilterSourceType.HSV
        self.outputType = FilterSinkType.BINARY

    def run(self, img):
        lower = (self.params['hMin'],
                 self.params['sMin'],
                 self.params['vMin'])
        upper = (self.params['hMax'],
                 self.params['sMax'],
                 self.params['vMax'])
        res = cv2.inRange(img, lower, upper)
        return res

if __name__=='__main__':
    img = cv2.imread('server/filters/lena.png')
    thresh = HSVThreshold()
    thresh.params['hMin'] = 100.0
    thresh.params['hMax'] = 200.0
    res = thresh.run(img)

    cv2.imshow('res', res)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
