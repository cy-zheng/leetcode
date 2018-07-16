/*
    java List<E> hashCode计算：

    Returns the hash code value for this list.  The hash code of a list
    is defined to be the result of the following calculation:
    <pre>{@code
        int hashCode = 1;
        for (E e : list)
            hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
    }</pre>
    This ensures that {@code list1.equals(list2)} implies that
    {@code list1.hashCode()==list2.hashCode()} for any two lists,
    {@code list1} and {@code list2}, as required by the general
    contract of {@link Object#hashCode}.
    @return the hash code value for this list
    @see Object#equals(Object)
    @see #equals(Object)
    
    为什么这个解法可以呢：
    1、都是从左上开始遍历的，而且遍历的时候依照一个确定的顺序，所以结果的顺序应该相同
    2、计算坐标是与x0，y0的相对差值
    3、每次遍历将grid元素修改，防止重复遍历
*/

class Solution {
    private static int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<List<List<Integer>>> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<List<Integer>> island = new ArrayList<>();
                if (dfs(i, j, i, j, grid, m, n, island))
                    islands.add(island);
            }
        }
        return islands.size();
    }

    private boolean dfs(int i0, int j0, int i, int j, int[][] grid, int m, int n, List<List<Integer>> island) {
        if (i < 0 || m <= i || j < 0 || n <= j || grid[i][j] <= 0) return false;
        island.add(Arrays.asList(i - i0, j - j0));
        grid[i][j] *= -1;
        for (int d = 0; d < 4; d++) {
            dfs(i0, j0, i + delta[d][0], j + delta[d][1], grid, m, n, island);
        }
        return true;
    }
}
