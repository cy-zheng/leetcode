class Solution {
    public int pathSum(int[] nums) {
        // m里面存的是从root到当前节点的path sum
        int[][] m = new int[5][8];
        for (int n : nums) {
            int i = n / 100; // i is 1 based index;
            int j = (n % 100) / 10 - 1; // j used 0 based index;
            int v = n % 10;
            m[i][j] = m[i - 1][j / 2] + v;
        }

        int sum = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                // 最后一层，或是没有子节点
                if (i == 4 || m[i][j] != 0 && m[i + 1][j * 2] == 0 && m[i + 1][j * 2 + 1] == 0){
                    sum += m[i][j];
                }
            }
        }
        return sum;        
    }
}
