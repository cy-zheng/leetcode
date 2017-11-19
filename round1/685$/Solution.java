/*
    参考Discuss答案
    有两种情况导致这些边构不成一棵树：
    1、有一个点有两个parent
    2、存在一个环
    
    当有一个节点，存在两个父节点时，我们不能确定哪一个是需要删掉的。
    需要将两个边都保存起来，检验删掉边1会不会让树有效，检验删掉边2会不会让树有效
    
    如果不存在有两个父节点的节点（意味着root节点存在parent），那么直接找环，删掉环的最后一个边
*/

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            if (root(parent, father) == child) {
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father;
        }
        return can2;
    }
    
    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }   
        return i;
    }
}
