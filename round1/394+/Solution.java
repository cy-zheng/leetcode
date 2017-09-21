import java.util.*;

class Solution {
    public String decodeString(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == ']') {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                list.add(Character.toString(s.charAt(i)));
            }
            else if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                if (sb.length() > 0 && !(sb.charAt(sb.length() - 1) <= '9' && sb.charAt(sb.length() - 1) >= '0')) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                sb.append(s.charAt(i));
            }
            else 
                sb.append(s.charAt(i));
        }
        if (sb.length() > 0)
            list.add(sb.toString());
        
        Stack<String> stack = new Stack<>();
        for (String curr : list) {
            if (curr.equals("]")) {
                String tmp = stack.pop();
                sb = new StringBuilder();
                while (!tmp.equals("[")) {
                    sb.insert(0, tmp);
                    tmp = stack.pop();
                }
                int count = Integer.parseInt(stack.pop());
                StringBuilder sb1 = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    sb1.append(sb.toString());
                }
                stack.push(sb1.toString());
            }
            else {
                stack.push(curr);
            }         
        }
        StringBuilder result = new StringBuilder();
        while (stack.size() > 0) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}