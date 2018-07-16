import java.util.*;

class KthLargest {
    
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int n : nums) {
            if (pq.size() == k) {
                if (pq.peek() < n) {
                    pq.poll();
                    pq.add(n);
                }
            }  
            else {
                pq.add(n);
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() == k) {
            if (pq.peek() < val) {
                pq.poll();
                pq.add(val);
            }
        }  
        else {
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
