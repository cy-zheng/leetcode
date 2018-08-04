/*
    这道题的巧妙之处在于，不是从一个角落往外BFS的，而是把矩阵看成多个排序数组，这样就成了多个排序数组求第k大问题
    比如:
    1/2 > 1/3 > 1/5
          2/3 > 2/5
                3/5
    这样先把右边三个先入队，找到最小的，添加对应左边的元素。
    这样复杂度由BFS的O(K*log(N^2)) = O(2Klog(N))
    减少为O(K*log(N))
    不过也是坑，把常数复杂度降低一倍就过了
    
    有O(n)的解法
    https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115545/O(n)
*/

import java.util.*;

class Point implements Comparable<Point> {
    int x, y;
    double value;
    Point(int x, int y, double value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
    public int compareTo(Point other) {
        if (this.value < other.value)
            return -1;
        else if (this.value == other.value)
            return 0;
        else 
            return 1;
    }
}

public class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        Set<String> set = new HashSet<>();
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < A.length - 1; i++) {
            pq.add(new Point(i, A.length - 1, 1.0 * A[i] / A[A.length - 1]));
        }
        for (int i = 1; i < K; i++) {
            Point curr = pq.poll();
            if (curr.y - 1 > curr.x) {
                pq.add(new Point(curr.x, curr.y - 1, 1.0 * A[curr.x] / A[curr.y - 1]));
            }
        }
        Point res = pq.poll();
        return new int[] {A[res.x], A[res.y]};
    }
}
