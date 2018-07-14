/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return null;
        return helper(grid, 0, 0, grid.length - 1, grid.length - 1);
    }
    
    private Node helper(int[][] grid, int x1, int x2, int y1, int y2) {
        if (x1 == y1 && x2 == y2) {
            return new Node(grid[x1][x2] == 1, true, null, null, null, null);
        }
        
        int diff = y1 - x1 + 1;
        
        Node tl, tr, bl, br;
        
            tl = helper(grid, x1, x2, x1 + diff / 2 - 1, x2 + diff / 2 - 1);
            tr = helper(grid, x1, x2 + diff / 2, x1 + diff / 2 - 1, y2);
            bl = helper(grid, x1 + diff / 2, x2, y1, x2 + diff / 2 - 1);
            br = helper(grid, x1 + diff / 2, x2 + diff / 2, y1, y2);
        
        
        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf) {
            boolean same = true;
            if (tr.val != tl.val)
                same = false;
            if (bl.val != tl.val)
                same = false;
            if (br.val != tl.val)
                same = false;
            if (same)
                return new Node(tl.val, true, null, null, null, null);
        }
        return new Node(true, false, tl, tr, bl, br);
    }
}
