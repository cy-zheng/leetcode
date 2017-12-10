/*
    一道双指针维护滑动窗口的题目
*/

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (t.equals("") || t.length() > s.length())
            return "";
        
        // targetMap保存t中的字母计数
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> currMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        String result = "";
        int left = 0, right = 1;
        currMap.put(s.charAt(left), 1);
        while (left < right && left < s.length() && right <= s.length()) {
            // 如果当前currMap没达到targetMap要求的话，right右移
            while (right < s.length() && !isEnough(targetMap, currMap)) {
                currMap.put(s.charAt(right), currMap.getOrDefault(s.charAt(right), 0) + 1);
                right += 1;
            }
            
            // 如果达到要求了，left尝试左移
            if (isEnough(targetMap, currMap)) {
                while (currMap.get(s.charAt(left)) > targetMap.getOrDefault(s.charAt(left), 0)) {
                    currMap.put(s.charAt(left), currMap.get(s.charAt(left)) - 1);
                    left += 1;
                }
            }
            
            // 如果达到要求了，根据left左移之后的结果，更新result
            if (isEnough(targetMap, currMap) && (result.equals("") || result.length() > right - left))
                result = s.substring(left, right);
            
            // 从当前窗口跳出，left左移
            currMap.put(s.charAt(left), currMap.get(s.charAt(left)) - 1);
            if (currMap.get(s.charAt(left)) == 0)
                currMap.remove(s.charAt(left));
            left += 1;
            
            // 如果right已经到最右了，那么不可能有下一个有效的答案了（此时left已经最佳了），可以break了
            if (right == s.length())
                break;
        }

        return result;
    }

    private boolean isEnough(Map<Character, Integer> targetMap, Map<Character, Integer> currMap) {
        for (Character key : targetMap.keySet()) {
            if (!currMap.containsKey(key) || currMap.get(key) < targetMap.get(key))
                return false;
        }
        return true;
    }
}
