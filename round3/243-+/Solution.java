import java.util.*;

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
        int i = 0, j = 0;
        int result = Integer.MAX_VALUE;
        while (i < map.get(word1).size() && j < map.get(word2).size()) {
            while (i < map.get(word1).size() && i < map.get(word1).size() && map.get(word1).get(i) < map.get(word2).get(j)) {
                result = Math.min(result, map.get(word2).get(j) - map.get(word1).get(i));
                i += 1;
            }
            while (i < map.get(word1).size() && j < map.get(word2).size() && map.get(word1).get(i) > map.get(word2).get(j)) {
                result = Math.min(result, map.get(word1).get(i) - map.get(word2).get(j));
                j += 1;
            }
        }
        return result;
    }
}

// more clear solution
public int shortestDistance(String[] words, String word1, String word2) {
    int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
    
    for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word1)) 
            p1 = i;

        if (words[i].equals(word2)) 
            p2 = i;
            
        if (p1 != -1 && p2 != -1)
            min = Math.min(min, Math.abs(p1 - p2));
    }
    
    return min;
}
