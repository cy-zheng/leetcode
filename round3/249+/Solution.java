/*
    注意a-z == b-a，所以需要取余
*/

import java.util.*;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String s : strings) {
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (key.length() != 0)
                    key.append(",");
                int preIndex = Math.max(i - 1, 0);
                int diff = (s.charAt(i) - s.charAt(preIndex) + 26) % 26;
                key.append(Integer.toString(diff));
            }
            if (!map.containsKey(key.toString()))
                map.put(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(s);
        }
        
        for (String k : map.keySet()) {
            result.add(map.get(k));
        }
        return result;
    }
}
