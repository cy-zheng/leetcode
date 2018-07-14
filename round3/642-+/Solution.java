import java.util.*;

class Item implements Comparable<Item> {
    String str;
    int times;
    public Item(String str, int times) {
        this.str = str;
        this.times = times;
    }
    
    public int compareTo(Item other) {
        if (this.times != other.times)
            return other.times - this.times;
        return this.str.compareTo(other.str);
    }
}

public class AutocompleteSystem {
    
    Map<String, Integer> map;
    String curr;

    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
            map.put(sentences[i], times[i]);
        }
        curr = "";
    }
    
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            curr = "";
            return result;
        }
        else {
            curr += c;
            List<Item> candidates = new ArrayList<>();
            for (String key : map.keySet()) {
                if (key.indexOf(curr) == 0) {
                    candidates.add(new Item(key, map.get(key)));
                }
            }
            
            Collections.sort(candidates);
            for (int i = 0; i < Math.min(3, candidates.size()); i++) {
                result.add(candidates.get(i).str);
            }
            return result;
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
