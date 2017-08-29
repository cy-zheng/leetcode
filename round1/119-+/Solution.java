/*
    int越界，用long
*/

import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long up = 1, down = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            up *= i;
            down *= i;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            if (i != 0) {
                down = down * i / (rowIndex + 1 - i);
            }
            result.add((int) (up / down));
        }
        return result;
    }
}