/*
    单调栈和贪心的结合
    不需要考虑当前元素，选择当前这个还是下一个
    考虑的是，对于当前元素的前一个元素，如果是一个逆序，而且后面还有前一个元素（根据map计数），那么就删掉前一个元素
*/

import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {        // 计算各个字符的出现次数
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);   // 只要遍历过，计数器--
            if (set.contains(s.charAt(i)))                    // 已经在stack中，不考虑当前元素是否逆序。即使逆序，选择之前的就好，丢弃当前元素
                continue;
            while (stack.size() > 0 && stack.peek() >= s.charAt(i) && map.get(stack.peek()) > 0) {  // 不在stack中，考虑逆序情况
                set.remove(stack.pop());             // 这样保证stack中元素基本都是顺序的，除了元素个数不足的情况
            }
            stack.push(s.charAt(i));     // 加入这个元素
            set.add(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();       // 组成字符串
        while (stack.size() > 0) 
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}