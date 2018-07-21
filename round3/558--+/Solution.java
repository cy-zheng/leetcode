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
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node(quadTree1.val || quadTree2.val, true, null, null, null, null);
        }
        else if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return new Node(true, true, null, null, null, null);
            }
            else {
                return quadTree2;
            }
        }
        else if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                return new Node(true, true, null, null, null, null);
            }
            else {
                return quadTree1;
            }
        }
        else {
            Node result = new Node(true, 
                                   false,
                                   intersect(quadTree2.topLeft, quadTree1.topLeft),
                                   intersect(quadTree2.topRight, quadTree1.topRight),
                                   intersect(quadTree2.bottomLeft, quadTree1.bottomLeft),
                                   intersect(quadTree2.bottomRight, quadTree1.bottomRight));
            boolean canMerge = true;
            if (!result.topLeft.isLeaf || result.topLeft.val != result.topLeft.val)
                canMerge = false;
            if (!result.topRight.isLeaf || result.topRight.val != result.topLeft.val)
                canMerge = false;
            if (!result.bottomLeft.isLeaf || result.bottomLeft.val != result.topLeft.val)
                canMerge = false;
            if (!result.bottomRight.isLeaf || result.bottomRight.val != result.topLeft.val)
                canMerge = false;
            if (canMerge) {
                return new Node(result.topLeft.val, true, null, null, null, null);
            }
            else {
                return result;
            }
        }
    }
}
