class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0;
        int[] dist = new int[nuts.length];
        for (int i = 0; i < nuts.length; i++) {
            dist[i] = diff(nuts[i], tree);
            sum += 2 * dist[i];
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nuts.length; i++) {
            int r = sum - dist[i] + diff(nuts[i], squirrel);
            result = Math.min(r, result);
        }
        return result;
    }
    
    private int diff(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
}
