import java.util.*;

class WordDistance {
    
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int i = 0, j = 0;
        int result = Integer.MAX_VALUE;
        while (i < map.get(word1).size() && j < map.get(word2).size()) {
            while (i < map.get(word1).size() && i < map.get(word1).size() 
                   && map.get(word1).get(i) < map.get(word2).get(j)) {
                result = Math.min(result, map.get(word2).get(j) - map.get(word1).get(i));
                i += 1;
            }
            while (i < map.get(word1).size() && j < map.get(word2).size() 
                   && map.get(word1).get(i) > map.get(word2).get(j)) {
                result = Math.min(result, map.get(word1).get(i) - map.get(word2).get(j));
                j += 1;
            }
        }
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
