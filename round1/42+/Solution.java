class Solution {
    public int trap(int[] height) {
        int result = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            while (left < right && height[left] <= height[right]) {
                if (leftMax > height[left]) {
                    result += leftMax - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }
            while (left < right && height[left] > height[right]) {
                if (rightMax > height[right]) {
                    result += rightMax - height[right];
                }
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }

        return result;
    }
}
