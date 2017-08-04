/*
    双指针问题
    有一个隐含条件：left的高度小于right的高度时，right以左（至left）所有元素与left组成的容器，容积都不如left和right组成的大。
    依据这个条件可以使用对撞型指针，一次舍去O(n)的组合
*/

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}