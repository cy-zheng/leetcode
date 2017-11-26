/*
    使用Map实现的UnionFind
*/

import java.util.*;

class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        Map<String, String> parent = new HashMap<>();
        for (String[] pair : pairs) 
            add(parent, pair[0], pair[1]);
        
        if (words1.length != words2.length)
            return false;
        for (int i = 0; i < words1.length; i++) {
            if (!find(parent, words1[i]).equals(find(parent, words2[i])))
                return false;
        }
        return true;
    }
    
    private void add(Map<String, String> map, String s1, String s2) {
        if (!map.containsKey(s1))
            map.put(s1, s1);
        if (!map.containsKey(s2))
            map.put(s2, s2);
        String p1 = find(map, s1);
        String p2 = find(map, s2);
        if (!p1.equals(p2))
            map.put(p1, p2);
    }
    
    private String find(Map<String, String> map, String s) {
        if (!map.containsKey(s))
            return "";
        String currParent = map.get(s), currString = s;
        while (!currParent.equals(currString)) {
            currString = currParent;
            currParent = map.get(currString);
        }
        map.put(s, currParent);
        return currParent;
    }
}
