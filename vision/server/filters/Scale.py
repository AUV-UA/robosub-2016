from visionservice.ttypes import *
import cv2

class Scale:
    inputTypes = [
        FilterSourceType.RGB,
        FilterSourceType.BGR,
        FilterSourceType.HSV,
        FilterSourceType.HSL,
        FilterSourceType.BINARY
    ]
    outputTypes = [
        FilterSinkType.RGB,
        FilterSinkType.BGR,
        FilterSinkType.HSV,
        FilterSinkType.HSL,
        FilterSinkType.BINARY
    ]
    paramList = ['xRatio', 'yRatio']

    def __init__(self):
        self.params = {
            'xRatio': 1.0,
            'yRatio': 1.0
        }
        self.inputType = FilterSourceType.RGB
        self.outputType = FilterSinkType.RGB

    def run(self, img):
        res = cv2.resize(img, None,
            fx=self.params['xRatio'], fy=self.params['yRatio'],
            interpolation=cv2.INTER_CUBIC)
        return res

if __name__=='__main__':
    img = cv2.imread('server/filters/lena.png')
    scale = Scale()
    scale.params['xRatio'] = 0.5
    scale.params['yRatio'] = 0.5
    res = scale.run(img)

    cv2.imshow('res', res)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
