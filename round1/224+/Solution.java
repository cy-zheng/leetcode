/*
    拆成两部分（两个stack）：
    一个栈用来处理括号匹配
    一个栈用来处理简单的加减法（不带括号）
    
    java List不能随机插入，需要用Deque做头插，api：
        addFirst(e)
        addLast(e)
        pollFirst()
        pollLast()
        peekFirst()
        peekLast()
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
            else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(' || s.charAt(i) == ')') {
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
        Deque<String> tmp;
        for (String item : strings) {
            if (item.equals(")")) {
                tmp = new LinkedList<>();
                String cur1 = stack.pop();
                while (!cur1.equals("(")) {
                    tmp.addFirst(cur1);
                    cur1 = stack.pop();
                }
                stack.push(baseCalc(tmp));
            }
            else {
                stack.push(item);
            }
        }
        tmp = new LinkedList<>();
        while (stack.size() != 0) {
            tmp.addFirst(stack.pop());
        }
        return Integer.parseInt(baseCalc(tmp));
    }
    
    private String baseCalc(Deque<String> list) {
        if (list == null || list.size() == 0)
            return "0";
        
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.equals("+") || s.equals("-")) {
                stack.push(s);
            }
            else {
                if (stack.size() == 0) {
                    stack.push(s);
                }
                else {
                    if (stack.pop().equals("+")) {
                        stack.push(Integer.toString(Integer.parseInt(stack.pop()) + Integer.parseInt(s)));
                    }
                    else {
                        stack.push(Integer.toString(Integer.parseInt(stack.pop()) - Integer.parseInt(s)));
                    }
                }
            }
        }
        return stack.pop();
    }
                           
}