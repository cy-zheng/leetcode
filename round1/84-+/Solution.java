import java.util.*;

class Solution {
    
    class Item {
        int val, index;
        public Item(int val, int index) {
            this.val = val;
            this.index = index;
        }
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
            
            // 当每次触发弹栈时，记录最右下标，当前Item一定小于等于最右Item，所以一直到最右，一定能被当前元素组成的矩形包括进去
            int rightIndex = -1;
            if (stack.size() > 0 && stack.peek().val > curr) 
                rightIndex = stack.peek().index;
            
            while (stack.size() > 0 && stack.peek().val > curr) {
                Item last = stack.pop();
                // 当前元素高度作为高的矩形，最左能到的地方
                // 如果栈中存在上一个元素，那么最左一定是peek的下一个位置。如果stack为empty，那么最左一直到0
                int lastIndex = stack.size() > 0 ? stack.peek().index + 1 : 0;
                result = Math.max(result, last.val * (rightIndex - lastIndex + 1));
            }
            stack.push(new Item(curr, i));
        }
        return result;
    }
}
