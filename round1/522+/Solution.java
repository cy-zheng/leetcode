/*
    比较brute force的解法，找到所有子串，然后看是不是只有一个
*/

import java.util.*;

class Solution {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            for (String subSeq : getSubSeq(str)) {
                map.put(subSeq, map.getOrDefault(subSeq, 0) + 1);
            }
        }
        
        int res = -1;
        for (String key : map.keySet()) {
            res = Math.max(res, map.get(key) == 1 ? key.length() : -1);
        }
        return res;
    }
    
    private List<String> getSubSeq(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }
            
        List<String> tmp = getSubSeq(s.substring(1));
        for (String t : tmp) {
            result.add(t);
            result.add(s.charAt(0) + t);
        }
        return result;
    }
}
