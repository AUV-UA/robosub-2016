from filters import RedMarkerFilter
import cv2
import numpy as np

if __name__ == "__main__":
    lower = np.array([150,0,0])
    upper = np.array([255,230,230])

    image = cv2.imread("images/lines.jpg")

    filtered_image = RedMarkerFilter.RedMarkerFilter(lower, upper, image, True)
    filtered_image.apply_filter()
