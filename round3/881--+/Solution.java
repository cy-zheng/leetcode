import java.util.*;

class Solution {
    
    private int row, col;
    private PriorityQueue<Integer> pq;
    private Random rand;

    public Solution(int n_rows, int n_cols) {
        row = n_rows;
        col = n_cols;
        pq = new PriorityQueue<>();
        rand = new Random();
    }
    
    public int[] flip() {
        int index = rand.nextInt(row * col - pq.size());
        List<Integer> tmp = new ArrayList<>();
        while (pq.size() > 0 && pq.peek() <= index) {
            tmp.add(pq.poll());
            index += 1;
        }
        pq.addAll(tmp);
        pq.add(index);
        return new int[] {index / col, index % col};
    }
    
    public void reset() {
        pq = new PriorityQueue<>();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
