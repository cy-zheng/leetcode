import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            if (!set.contains(num)) {
                set.add(num);
                if (pq.size() < 3) {
                    pq.add(num);
                }
                else {
                    if (pq.peek() < num) {
                        pq.poll();
                        pq.add(num);
                    }
                }
            }
        }
        return pq.size() == 3 ? pq.poll() : max;
    }
}