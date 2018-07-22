import java.util.*;

class Item {
    int quiet;
    Set<Integer> next;
    Integer result = null;
    Item(int quiet) {
        this.quiet = quiet;
        this.next = new HashSet<>();
    }
}

public class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, Item> map = new HashMap<>();
        Map<Integer, Integer> reverse = new HashMap<>();
        for (int i = 0; i < quiet.length; i++) {
            map.put(i, new Item(quiet[i]));
            reverse.put(quiet[i], i);
        }
        
        for (int[] rich : richer) {
            map.get(rich[1]).next.add(rich[0]);
        }
        
        int[] result = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            result[i] = reverse.get(dfs(map, map.get(i)));
        }
        return result;
    }
    
    private int dfs(Map<Integer, Item> map, Item item) {
        if (item.result != null)
            return item.result;
        int result = item.quiet;
        for (int next : item.next) {
            result = Math.min(result, dfs(map, map.get(next)));
        }
        item.result = result;
        return result;
    }
}
