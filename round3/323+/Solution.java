/*
    找联通图还是应该优先考虑并查集
*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        int result = n;
        for (int[] edge : edges) {
            int f1 = find(father, edge[0]);
            int f2 = find(father, edge[1]);
            if (f1 != f2) {
                connect(father, f1, f2);
                result -= 1;
            }
        }
        return result;
    }
    
    private int find(int[] father, int curr) {
        while (curr != father[curr]) {
            father[curr] = father[father[curr]];
            curr = father[curr];
        }
        return curr;
    }
    
    private void connect(int[] father, int f1, int f2) {
        father[f1] = f2;
    }
}
