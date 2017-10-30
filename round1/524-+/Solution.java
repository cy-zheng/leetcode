import java.util.*;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        int distance = s.length();
        String result = "";
        
        for (String t : d) {
            int i = 0, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j))
                    i++;
                else {
                    i++;
                    j++;
                }
            }
            if (j != t.length())
                continue;
            if (s.length() - t.length() < distance) {
                result = t;
                distance = s.length() - t.length();
            }
        }
        return result;
    }
}