/*
    需要记录访问过的数据，2*3=6，3*2=6
    Long型转int型：Long.intValue
*/

import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.offer((long) 1);
        for (int i = 0; i < n - 1; i++) {
            long cur = pq.poll();
            if (!set.contains(cur * 2)) {
                set.add(cur * 2);
                pq.offer(cur * 2);
            }
            if (!set.contains(cur * 3)) {
                set.add(cur * 3);
                pq.offer(cur * 3);
            }
            if (!set.contains(cur * 5)) {
                set.add(cur * 5);
                pq.offer(cur * 5);
            }
        }
        return pq.poll().intValue();
    }
}