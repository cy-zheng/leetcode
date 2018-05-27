import java.util.*;

class Pair implements Comparable<Pair> {
    int difficulty, profit;
    public Pair(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }
    
    public int compareTo(Pair other) {
        if (this.difficulty == other.difficulty)
            return this.profit - other.profit;
        return this.difficulty - other.difficulty;
    }
}

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < profit.length; i++) {
            list.add(new Pair(difficulty[i], profit[i]));
        }
        Collections.sort(list);
        Arrays.sort(worker);
        
        int index = 0;
        int result = 0;
        int max = 0;
        for (int w : worker) {
            while (index < list.size() && list.get(index).difficulty <= w) {
                max = Math.max(max, list.get(index).profit);
                index += 1;
            }
            result += max;
        }
        return result;
    }
}
