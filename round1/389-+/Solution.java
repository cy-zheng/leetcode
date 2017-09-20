import java.util.*;

class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i), 0);
            map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map2.containsKey(t.charAt(i)))
                map2.put(t.charAt(i), 0);
            map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
        }
        for (char key : map2.keySet()) {
            if (!map1.containsKey(key) || map1.get(key) < map2.get(key))
                return key;
        }
        return '0';
    }
}