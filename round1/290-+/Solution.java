import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] list = str.split(" ");
        if (pattern.length() != list.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map1.containsKey(pattern.charAt(i)) && !map2.containsKey(list[i])) {
                map1.put(pattern.charAt(i), list[i]);
                map2.put(list[i], pattern.charAt(i));
            }
            else if (map1.containsKey(pattern.charAt(i)) && map2.containsKey(list[i])) {
                if (!map1.get(pattern.charAt(i)).equals(list[i]) || map2.get(list[i]) != pattern.charAt(i))
                    return false;
            }
            else
                return false;
        }
        
        return true;
    }
}