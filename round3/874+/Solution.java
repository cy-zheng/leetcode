class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] obs : obstacles) {
            if (obs[0] == 0 && obs[1] == 0) 
                continue;
            if (!map.containsKey(obs[0])) {
                map.put(obs[0], new HashSet<>());
            }
            map.get(obs[0]).add(obs[1]);
        }
        // dirs的顺序刚好是顺时针的，旋转正好按照他的下标
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, result = 0;
        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4) {
                    d = 0;
                }
            } else if (c == -2) {
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {
                int i = 0;
                while (i < c && (!map.containsKey(x) || !map.get(x).contains(y))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                    i++;
                }
                if (map.containsKey(x) && map.get(x).contains(y)) {
                    x -= dirs[d][0];
                    y -= dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}

