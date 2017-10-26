/*
    把所有的和记录到HashMap，然后排序
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    
    class Pair implements Comparable<Pair> {
        int sum, cnt;
        
        public Pair(int sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }
        
        public int compareTo(Pair other) {
            return other.cnt - this.cnt;
        }
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        dfs(map, root);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int sum : map.keySet()) 
            pq.add(new Pair(sum, map.get(sum)));
        List<Integer> sums = new ArrayList<>();
        int cnt = pq.peek().cnt;
        while (pq.size() > 0 && pq.peek().cnt == cnt)
            sums.add(pq.poll().sum);
        int[] r = new int[sums.size()];
        for (int i = 0; i < sums.size(); i++) {
            r[i] = sums.get(i);
        }
        return r;
    }
    
    private int dfs(Map<Integer, Integer> map, TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(map, root.left);
        int right = dfs(map, root.right);
        int r = root.val + left + right;
        map.put(r, map.getOrDefault(r, 0) + 1);
        return r;
    }
}