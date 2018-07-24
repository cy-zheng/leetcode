import java.util.*;

class Solution {
    class Item {
        int val, index;
        public Item(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] dp = new int[2][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1')
                    dp[i % 2][j] = dp[(i + 1) % 2][j] + 1;
                else 
                    dp[i % 2][j] = 0;
            }
            result = Math.max(result, largestRectangleArea(dp[i % 2]));
        }
        return result;
    }
    
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Item> stack = new Stack<>();
        
        for (int i = 0; i <= heights.length; i++) {
            int curr;   // 相当于在heights后面插入一个-1，强制前面所有元素弹栈
            if (i < heights.length)
                curr = heights[i];
            else
                curr = -1;
            int rightIndex = -1;
            if (stack.size() > 0 && stack.peek().val > curr) 
                rightIndex = stack.peek().index;
            
            while (stack.size() > 0 && stack.peek().val > curr) {
                Item last = stack.pop();
                int lastIndex = stack.size() > 0 ? stack.peek().index + 1 : 0;
                result = Math.max(result, last.val * (rightIndex - lastIndex + 1));
            }
            stack.push(new Item(curr, i));
        }
        return result;
    }
}
