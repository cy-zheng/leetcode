/*
    leetcode 316
    问题抽象：多个元素的序列，找一个元素只出现一次的子序列，排序最小
*/

import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            if (set.contains(s.charAt(i))) 
                continue;
            // 只要栈顶元素，比当前元素小，而且栈顶元素在后面还会出现，就出栈
            while (stack.size() > 0 && stack.peek() >= s.charAt(i) && map.get(stack.peek()) > 0) {
                set.remove(stack.pop());
            }
            stack.push(s.charAt(i));
            set.add(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) 
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}
