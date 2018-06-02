class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean verify(int[] preorder, int start, int end, int lower, int upper) {
        if (start > end)
            return true;
        if (start == end && preorder[start] > lower && preorder[start] < upper)
            return true;
        if (start == end)
            return false;
        if (preorder[start] < lower || preorder[start] > upper)
            return false;
        int root = preorder[start];
        int bigIndex = -1;
        boolean result = true;
        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] > root) {
                bigIndex = i;
                break;
            }
        }
        if (bigIndex != -1) {
            return verify(preorder, start + 1, bigIndex - 1, lower, root) && 
                verify(preorder, bigIndex, end, root, upper);
        }
        return verify(preorder, start + 1, end, lower, root);
    }
}
