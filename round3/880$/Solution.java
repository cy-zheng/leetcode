import java.util.*;

class Solution {
    
    private int cnt;
    private TreeMap<Integer, Integer> map; 
    private Random rand;

    public Solution(int[] w) {
        cnt = 0;
        map = new TreeMap<>();
        rand = new Random();
        for (int i = 0; i < w.length; i++) {
            cnt += w[i];
            map.put(cnt, i);
        }
    }
    
    public int pickIndex() {
        return map.get(map.ceilingKey(rand.nextInt(cnt) + 1));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
