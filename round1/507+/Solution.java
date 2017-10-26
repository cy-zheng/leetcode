class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {  
            return false;  
        }  
        int sum = 1, sqrt = (int)Math.sqrt(num);  // 最大到开根
        for (int i = 2; i <= sqrt; i ++) {  
            if (num % i == 0) {  
                sum += i + (i * i == num ? 0 : num / i);  // 6*6 只加一个6
            }  
        }  
        return sum == num; 
    }
}