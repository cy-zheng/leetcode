/*
    相当于投影到两个轴上，然后使用双指针求中点到两边的距离
*/

class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> I = new ArrayList<>(m);
        List<Integer> J = new ArrayList<>(n);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    I.add(i);
                    J.add(j);
                }
            }
        }

        return getMin(I) + getMin(J);
    }

    private int getMin(List<Integer> list){
        int ret = 0;

        Collections.sort(list);

        int i = 0;
        int j = list.size() - 1;
        // IMPORTANT
        while(i < j){
            ret += list.get(j--) - list.get(i++);
        }

        return ret;
    }
}
