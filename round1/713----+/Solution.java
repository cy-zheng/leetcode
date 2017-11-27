/*
    不需要维持一个全局的prefix数组，只要保持一个当前数组的部分和就好
    i和j组成了一个滑动窗口，partProduct是当前滑动窗口的乘积
    对于每个i，j首先向右扩展到最大，然后计算result
    然后i += 1
    
    Discuss的思路更加简洁，j作为循环变量，如果窗口乘积超过k，右移i
    
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int n = nums.length;
            long p = 1l;
            int i = 0;
            int j = 0;
            int total = 0;
            while(j < n){
                p *= nums[j];
                while(i <= j&&p >= k){
                    p /= nums[i];
                    i++;
                }
                total += (j - i + 1);
                j++;
            }
            return total;
        }
    }
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int i = 0, j = 0;
        long partProduct = nums[0];
        while (j + 1 < nums.length && partProduct * nums[j + 1] < k) {
            partProduct *= nums[j + 1];
            j += 1;
        }

        while (i <= j && i < nums.length && j < nums.length) {
            if (partProduct < k)
                result += j - i + 1;
            partProduct /= nums[i];
            i += 1;
            if (i >= nums.length)
                break;
            if (j < i) {
                j = i;
                partProduct = nums[i];
            }
            while (j + 1 < nums.length && partProduct * nums[j + 1] < k) {
                j += 1;
                partProduct *= nums[j];
            }
        }
        return result;
    }
}
