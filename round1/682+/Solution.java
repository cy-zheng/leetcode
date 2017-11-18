import java.util.*;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("+")) {
                int n2 = stack.pop();
                int n1 = stack.peek();
                stack.push(n2);
                stack.push(n1 + n2);
            }
            else if (s.equals("C"))
                stack.pop();
            else if (s.equals("D")) {
                stack.push(2 * stack.peek());
            }
            else
                stack.push(Integer.parseInt(s));
        }
        
        int result = 0;
        while (stack.size() > 0)
            result += stack.pop();
        return result;
    }
}
