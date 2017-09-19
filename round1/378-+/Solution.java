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
    
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        pq.offer(new Pair(0, 0, matrix[0][0]));
        for (int i = 1; i < k; i++) {
            Pair curr = pq.poll();
            if (curr.i + 1 < matrix.length && !visited[curr.i + 1][curr.j]) {
                visited[curr.i + 1][curr.j] = true;
                pq.offer(new Pair(curr.i + 1, curr.j, matrix[curr.i + 1][curr.j]));
            }
            if (curr.j + 1 < matrix[0].length && !visited[curr.i][curr.j + 1]) {
                visited[curr.i][curr.j + 1] = true;
                pq.offer(new Pair(curr.i, curr.j + 1, matrix[curr.i][curr.j + 1]));
            }
        }
        return pq.poll().val;
    }
}