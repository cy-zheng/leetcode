import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int left, right;
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                right = stack.pop();
                left = stack.pop();
                if (s.equals("+")) {
                    stack.push(left + right);
                }
                else if(s.equals("-")) {
                    stack.push(left - right);
                }
                else if(s.equals("*")) {
                    stack.push(left * right);
                }
                else{
                    stack.push(left / right);
                }
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}