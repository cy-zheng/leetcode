/*
    给定一个数组nums和一个数n，求添加最少的数使得[1,n]中的每个数都可以由数组中元素和组成用known_sum表示已知的连续和为[1,known_sum)，有了这个表示那就简单了：

    nums[i] <= known_sum，更新已知范围为：[1,known_sum + nums[i])
    nums[i] >  known_sum,  添加known_sum进数组才能达到最大的范围，所以已知范围更新为：[1,known_sum *2)
*/

class Solution {
    public int minPatches(int[] nums, int n) {
        int cnt = 0, i = 0;  
        long known_sum = 1;
        while (known_sum <= n) {  
            if (i < nums.length && nums[i] <= known_sum) {  
                known_sum += nums[i];
                i++;
            }  
            else {  
                known_sum <<= 1;  
                cnt++;  
            }  
        }  
        return cnt;  
    }
}