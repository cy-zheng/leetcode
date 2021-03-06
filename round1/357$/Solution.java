class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;  
        if(n==1) return 10;  
        int val = 9, ans = 10;  
        for(int i = 2; i <= n; i++)  
        {  
            val *= (9-i+2);  // 当前位数，1-9开始的个数
            ans += val;  // 以前的不重复数字个数+当前
        }  
        return ans;  
    }
}