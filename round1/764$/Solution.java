/*
    四个方向分别作dp矩阵，记录当前格子往上下左右最大连续1的个数
*/

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix = new int[N][N];
        for(int[] mat:matrix){
            Arrays.fill(mat, 1);
        }
        for(int[] mine: mines){
            matrix[mine[0]][mine[1]] = 0;
        }
        int ans = 0;
        if(mines.length<N*N) ans = 1;
        int[][] left = new int[N][N];
        int[][] right = new int[N][N];
        int[][] top = new int[N][N];
        int[][] bottom = new int[N][N];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(matrix[i][j]==1){ 
                    top[i][j] = (i-1>=0)?top[i-1][j]+1:1;
                    left[i][j] = (j-1>=0)?left[i][j-1]+1:1;
                }
                else{
                    left[i][j] = 0;
                    top[i][j] = 0;
                }
            }    
        }
        
        
        for(int i=N-1;i>=0;i--){
            for(int j=N-1;j>=0;j--){
                if(matrix[i][j]==1){ 
                    bottom[i][j] = (i+1<N)?bottom[i+1][j]+1:1;
                    right[i][j] = (j+1<N)?right[i][j+1]+1:1;
                }
                else{
                    bottom[i][j]=0;
                    right[i][j]=0;
                }
                ans = Math.max(ans, Math.min(Math.min(left[i][j],bottom[i][j]), Math.min(right[i][j],top[i][j])));
            }    
        }
        return ans;
    }
}
