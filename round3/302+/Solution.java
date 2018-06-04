import java.util.*;

class Solution {
    public int minArea(char[][] image, int x, int y) {
        int i1, i2, j1, j2, left, right;
        // i1
        left = 0;
        right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (scanRow(image, mid))
                right = mid;
            else
                left = mid;
        }
        if (scanRow(image, left))
            i1 = left;
        else
            i1 = right;
        // i2
        left = x;
        right = image.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (scanRow(image, mid))
                left = mid;
            else
                right = mid;
        }
        if (scanRow(image, right))
            i2 = right;
        else
            i2 = left;
        // j1
        left = 0;
        right = y;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (scanCol(image, mid))
                right = mid;
            else
                left = mid;
        }
        if (scanCol(image, left))
            j1 = left;
        else
            j1 = right;
        // j2
        left = y;
        right = image[0].length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (scanCol(image, mid))
                left = mid;
            else
                right = mid;
        }
        if (scanCol(image, right))
            j2 = right;
        else
            j2 = left;
        return (i2 - i1 + 1) * (j2 - j1 + 1);
    }
    
    private boolean scanRow(char[][] image, int i) {
        for (int j = 0; j < image[i].length; j++) {
            if (image[i][j] == '1')
                return true;
        }
        return false;
    }
    
    private boolean scanCol(char[][] image, int j) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][j] == '1')
                return true;
        }
        return false;
    }
}
