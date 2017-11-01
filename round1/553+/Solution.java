/*
    如果nums.length == 2，直接拼起来
    如果nums.length > 2，先计算第一个元素后面的
    后面的结果越小，最终得到的结果越大
*/

class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                builder.append("/(").append(nums[i]);
            } else {
                builder.append("/").append(nums[i]);
            }
        }
        
        return nums.length > 2 ? builder.append(")").toString() : builder.toString();
    }
}