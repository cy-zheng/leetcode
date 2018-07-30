class Solution {
    public int shortestPathLength(int[][] graph) {
        // dp存的是当前节点+当前已遍历节点bitmap，只要保证这两个不变的情况下，value越来越小就可以
	    int[][] dp = new int[graph.length][1<<graph.length];
        Queue<State> queue =  new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1<<i]=0;
            queue.offer(new State(1<<i, i));
        }
        
        while (!queue.isEmpty()) {
            State state = queue.poll();
            
            for (int next : graph[state.source]) {
                int nextMask = state.mask | 1 << next;
                if (dp[next][nextMask] > dp[state.source][state.mask]+1) {
                    dp[next][nextMask] = dp[state.source][state.mask]+1;
                    queue.offer(new State(nextMask, next));
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            res = Math.min(res, dp[i][(1<<graph.length)-1]);
        }
        return res;
	}

	class State {
		public int mask, source;
		public State(int m, int s) {
			mask=m;
			source=s;
		}
	}
}
