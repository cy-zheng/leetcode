/*
    simple BFS
*/

import java.util.*;

class Solution {
    public int findCircleNum(int[][] M) {
        int result = 0;
        if (M == null || M.length == 0 || M[0].length == 0)
            return result;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                result++;
                queue.add(i);
                visited[i] = true;
                while (queue.size() > 0) {
                    int curr = queue.poll();
                    for (int j = 0; j < M.length; j++) {
                        if (!visited[j] && M[curr][j] == 1) {
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        
        return result;
    }
}