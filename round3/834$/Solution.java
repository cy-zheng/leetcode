import java.util.*;

class Solution {
    int[] res, count; 
    List<HashSet<Integer>> tree; 
    int n;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        // tree存的是该节点所有能到达的neighbor
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        // 以0为root，i节点的子树节点个数
        count = new int[N];
        n = N;
        for (int i = 0; i < N ; ++i ) 
            tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]); 
            tree.get(e[1]).add(e[0]);
        }
        // 假设0节点是root，先序遍历，这时res存的是i节点到子树所有节点的距离和
        // 0节点已经是答案了
        dfs(0, new HashSet<Integer>());
        // 补全其他节点的res
        dfs2(0, new HashSet<Integer>());
        return res;
    }

    public void dfs(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                // 注意root传i
                dfs(i, seen);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
        count[root]++;
    }


    public void dfs2(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                // 当前节点的距离 = 上层节点的距离 - 该节点的子节点个数（更靠近了子节点，每个距离减一)
                // + root节点及root其他children节点个数（远离了父节点和他的children，距离加一）
                res[i] = res[root] - count[i] + n - count[i];
                dfs2(i, seen);
            };
    }
}
