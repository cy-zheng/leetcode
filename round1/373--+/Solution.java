/*
    此题目不适用于两个指针算法
    判断题目能不能用两根指针算法：
    1、画一个n*n的矩阵
    2、从一个角开始遍历，看看是不是只有向对角运动
    如果有回头路，不能用两根指针
*/

import java.util.*;

class Solution {
    
    class Pair implements Comparable<Pair> {
        int i;
        int j;
        int sum;
        
        public Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
        
        public int compareTo(Pair other) {
            return this.sum - other.sum;
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return result;
        
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0, nums1[0] + nums2[0]));
        
        while (pq.size() > 0 && result.size() < k) {
            Pair curr = pq.poll();
            int[] tmp = new int[2];
            tmp[0] = nums1[curr.i];
            tmp[1] = nums2[curr.j];
            result.add(tmp);
            if (curr.i + 1 < nums1.length && !visited[curr.i + 1][curr.j]) {
                visited[curr.i + 1][curr.j] = true;
                pq.offer(new Pair(curr.i + 1, curr.j, nums1[curr.i + 1] + nums2[curr.j]));
            }
            if (curr.j + 1 < nums2.length && !visited[curr.i][curr.j + 1]) {
                visited[curr.i][curr.j + 1] = true;
                pq.offer(new Pair(curr.i, curr.j + 1, nums1[curr.i] + nums2[curr.j + 1]));
            }
        }
        
        return result;
    }
}