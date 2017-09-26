/*
    Heap + BFS
*/

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int i, j, val;
        public Pair(int i, int j, int val) {
            this.i = i; 
            this.j = j;
            this.val = val;
        }
        public int compareTo(Pair other) {
            return this.val - other.val;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3)
            return 0;
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < heightMap.length; i++) {
            visited[i][0] = true;
            pq.add(new Pair(i, 0, heightMap[i][0]));
            visited[i][heightMap[0].length - 1] = true;
            pq.add(new Pair(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
        }
        
        for (int j = 1; j < heightMap[0].length - 1; j++) {
            visited[0][j] = true;
            pq.add(new Pair(0, j, heightMap[0][j]));
            visited[heightMap.length - 1][j] = true;
            pq.add(new Pair(heightMap.length - 1, j, heightMap[heightMap.length - 1][j]));
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int result = 0;
        while (pq.size() != 0) {
            Pair curr = pq.poll();
            for (int i = 0; i < 4; i++) {
                if (test(curr.i + dx[i], curr.j + dy[i], visited)) {
                    visited[curr.i + dx[i]][curr.j + dy[i]] = true;
                    if (heightMap[curr.i + dx[i]][curr.j + dy[i]] < curr.val) {
                        pq.add(new Pair(curr.i + dx[i], curr.j + dy[i], curr.val));
                        result += curr.val - heightMap[curr.i + dx[i]][curr.j + dy[i]];
                    }
                    else {
                        pq.add(new Pair(curr.i + dx[i], curr.j + dy[i], heightMap[curr.i + dx[i]][curr.j + dy[i]]));
                    }
                }
            }
        }
        return result;
    }
    
    private boolean test(int i, int j, boolean[][] visited) {
        if (i < 0 || i >= visited.length)
            return false;
        if (j < 0 || j >= visited[0].length)
            return false;
        return !visited[i][j];
    }
}