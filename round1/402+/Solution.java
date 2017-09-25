/*
    单调栈经典题目
*/

import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (k != 0 && index < num.length()) {
            while (stack.size() > 0 && stack.peek() > num.charAt(index) && k != 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index));
            index++;
        }
        while (index < num.length())
            stack.push(num.charAt(index++));
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0)
            sb.insert(0, stack.pop());
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb = new StringBuilder(sb.substring(1, sb.length()));
        if (sb.length() <= k)
            return "0";
        return sb.substring(0, sb.length() - k).toString();
    }
}