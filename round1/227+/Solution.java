/*
    两次栈操作，一次计算乘除，一次计算加减
*/

import java.util.*;

class Solution {
    public int calculate(String s) {
        List<String> strings = new ArrayList<>();
        String cur = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (!cur.equals("")) {
                    strings.add(cur);
                    cur = "";
                }
                continue;
            }
            else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (!cur.equals("")) {
                    strings.add(cur);
                    cur = "";
                }
                strings.add(Character.toString(s.charAt(i)));
            }
            else {
                cur += Character.toString(s.charAt(i));
            }
        }
        if (!cur.equals("")) {
            strings.add(cur);
        }

        Stack<String> stack = new Stack<>();
        for (String item : strings) {
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
                stack.push(item);
            }
            else {
                if (stack.size() == 0 || stack.peek().equals("+") || stack.peek().equals("-")) {
                    stack.push(item);
                }
                else {
                    if (stack.pop().equals("*")) {
                        stack.push(Integer.toString(Integer.parseInt(stack.pop()) * Integer.parseInt(item)));
                    }
                    else {
                        stack.push(Integer.toString(Integer.parseInt(stack.pop()) / Integer.parseInt(item)));
                    }
                }
            }
        }
        Stack<String> stack2 = new Stack<>();
        for (String item : stack) {
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
                stack2.push(item);
            }
            else {
                if (stack2.size() == 0) {
                    stack2.push(item);
                }
                else {
                    if (stack2.pop().equals("+")) {
                        stack2.push(Integer.toString(Integer.parseInt(stack2.pop()) + Integer.parseInt(item)));
                    }
                    else {
                        stack2.push(Integer.toString(Integer.parseInt(stack2.pop()) - Integer.parseInt(item)));
                    }
                }
            }
        }
        return Integer.parseInt(stack2.pop());
    }
    
}