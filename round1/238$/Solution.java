/*
    这道题注意不使用* / %实现除法
    需要记录0的个数：
    两个以上0，所有result=0
    一个0，只有0对应的result不为0
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        long all = 1;
        int cnt = 0;
        for (int i : nums) {
            if (i != 0) {
                all *= i;
            }
            else 
                cnt++;
        }
        if (cnt == nums.length)
            all = 0 ;
            
        for (int i = 0; i < nums.length; i++) {
            if (cnt > 1)
                result[i] = 0;
            else if (cnt == 1 && nums[i] != 0)
                result[i] = 0;
            else
                result[i] = divide((int) all, nums[i]);
        }
        return result;
    }
    
    private int divide(int dividend, int divisor) {
        if (divisor == 0) {
             return dividend;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
                             
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative? -result: result;
    }
}