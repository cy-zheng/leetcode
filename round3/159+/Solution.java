import java.util.*;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int result = 0;
        while (i < s.length() && j < s.length()) {
            while (j < s.length() && !test(map, s.charAt(j))) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j += 1;
            }
            result = Math.max(result, j - i);
            while (i < s.length() && map.keySet().size() == 2) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i += 1;
            }
        }
        return result;
    }
    
    private boolean test(Map<Character, Integer> map, char curr) {
        if (map.keySet().size() == 2 && !map.containsKey(curr))
            return true;
        return false;
    }
}
