/*
    注意判断node == null
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.*;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        queue.offer(node);
        set.add(node);
        
        while (queue.size() != 0) {
            UndirectedGraphNode cur = queue.poll();
            map.put(cur, new UndirectedGraphNode(cur.label));
            
            for (UndirectedGraphNode i : cur.neighbors) {
                if (!set.contains(i)) {
                    set.add(i);
                    queue.offer(i);
                }
            }
        }
        
        set.clear();
        queue.offer(node);
        set.add(node);
        
        while (queue.size() != 0) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode i : cur.neighbors) {
                map.get(cur).neighbors.add(map.get(i));
                if (!set.contains(i)) {
                    set.add(i);
                    queue.offer(i);
                }
            }
        }
        
        
        return map.get(node);
    }
}