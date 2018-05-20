/*
    题目意思是是否存在node的划分，使得所有的边横跨于两个点集之间。
    需要检测图是否存在不联通部分。
*/

import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return true;
        
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < graph.length; i++) {
            if (!s1.contains(i) && !s2.contains(i)) {
                queue.add(i);
                s1.add(i);
                while (queue.size() > 0) {
                    int curr = queue.poll();
                    if (s1.contains(curr)) {
                        for (int next : graph[curr]) {
                            if (s1.contains(next))
                                return false;
                            else if (s2.contains(next))
                                continue;
                            else {
                                queue.add(next);
                                s2.add(next);
                            }
                        }
                    }
                    else {
                        for (int next : graph[curr]) {
                            if (s2.contains(next))
                                return false;
                            else if (s1.contains(next))
                                continue;
                            else {
                                queue.add(next);
                                s1.add(next);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
