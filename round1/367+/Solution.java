/*
    类似于sqrtx，二分法找根
*/

class Solution {
    public boolean isPerfectSquare(int num) {
        int root = (int) (sqrt(num) + 0.00001);
        return root * root == num;
    }
    
    private double sqrt(int num) {
        double left = 0, right = num;
        while (left + 0.00001 < right) {
            double mid = (left + right) / 2;
            if (mid * mid > num)
                right = mid;
            else
                left = mid;
        }
        return left;
    }
}