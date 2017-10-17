/*
    区间与单调栈的结合体，栈中的区间，从前向后依次变小，后一个的最大值严格小于前一个的最小值
*/


import java.util.*;

class Solution {
    
    class Pair {
        int min, max;
        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        for(int n: nums){
            if(stack.isEmpty() || n <stack.peek().min ) stack.push(new Pair(n,n));    // 新来的数字很小，不在当前区间范围
            else if(n > stack.peek().min){ 
                Pair last = stack.pop();
                if(n < last.max) return true;                   // 在当前范围之内，返回
                else {
                    last.max = n;                                                     // 比当前区间大，向前合并区间
                    while(!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    // At this time, n < stack.peek().max (if stack not empty)
                    if(!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }
                
            }
        }
        return false;
    }
}