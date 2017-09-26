import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) 
                map.put(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        
        int result = 0;
        boolean hasOdd = false;
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 0)
                result += map.get(key);
            else {
                result += map.get(key) - 1;
                hasOdd = true;
            }
        }
        
        return result + (hasOdd ? 1 : 0);
    }
}