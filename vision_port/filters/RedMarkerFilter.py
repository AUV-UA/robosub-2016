import cv2
import numpy as np
import math

class RedMarkerFilter:
    def __init__(self, lower, upper, image, draw_indicators):
        self.lower = lower
        self.upper = upper
        self.image = image
        self.draw_indicators = draw_indicators
        
        self.buoy_visible = False
        self.x_position = 320.0
        self.y_position = 240.0
        self.size = 0.0
        
    def apply_filter(self):

        rgb = cv2.cvtColor(self.image, cv2.COLOR_BGR2RGB)
        filtered = cv2.inRange(rgb, self.lower, self.upper)

        avg_center = (-1, -1)

        moms = cv2.moments(filtered)

        size = moms['m00'] / 100

        if size != 0:

            avg_X = int(moms['m10'] / moms['m00'])
            avg_Y = int(moms['m01'] / moms['m00'])

            self.buoy_visible = True
            self.x_position = avg_X
            self.y_position = avg_Y
            self.size = size

            if self.draw_indicators:
                image_out = self.image.copy()
                cv2.circle(image_out, (avg_X, avg_Y), 5, (255,0,0), 3)
                cv2.imwrite('output.jpg', image_out)
