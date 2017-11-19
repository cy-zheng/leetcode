/*
    并查集基本案例
    一个足够大的数组，表示各个节点的parent，初始化为自身下标
    一个find方法
*/

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];             // 初始化parent数组
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        
        for (int[] edge: edges){
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t)) return edge;   // 如果两个节点本身就是联通的，那说明新的边会加入一个环
            else parent[find(parent, f)] = find(parent, t);      // 合并两个集合 
        }
        
        return new int[2];
    }
    
    private int find(int[] parent, int f) {    // 寻找一个节点的parent节点
        if (f != parent[f]) {
          parent[f] = find(parent, parent[f]);  // 注意要更新当前节点的parent，相当于压缩树的高度
        }
        return parent[f];
    }
}
