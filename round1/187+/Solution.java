import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        if (s.length() < 10) return result;
        int left = 0, right = 10;
        Integer count;
        String cur;
        while (right <= s.length()) {
            cur = s.substring(left, right);
            if (map.containsKey(cur) && map.get(cur) == 1)
                result.add(cur);
            count = map.get(cur);
            if (count == null) 
                map.put(cur, 1);
            else
                map.put(cur, count + 1);
            
            left++;
            right++;
        }
        return result;
    }
}