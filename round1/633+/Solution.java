/*
    类似于two sum
*/

class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0)
            return false;
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int curr = i * i + j * j;
            if (curr < c)
                i++;
            else if (curr > c)
                j--;
            else
                return true;
        }
        return false;
    }
}