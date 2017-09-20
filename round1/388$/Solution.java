/*
    来自discuss，思路简洁，代码清楚
*/

import java.util.*;

class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.add(0);
        for (String tmp : input.split("\n")) {
            int level = tmp.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) 
                stack.pop();
            
            int len = stack.peek() + tmp.length() - level + 1;  //remove '\t' and '/'
            stack.push(len);
            if(tmp.contains(".")) 
                result = Math.max(result, len - 1); 
        }
        return result;
    }
}