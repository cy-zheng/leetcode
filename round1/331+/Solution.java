class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        if (preorder.equals("") || list == null || list.length == 0)
            return true;
        
        return dfs(0, list) == list.length;
    }
    
    private int dfs(int index, String[] list) {
        if (index >= list.length)
            return -1;
        if (list[index].equals("#"))
            return index + 1;
        int left = dfs(index + 1, list);
        if (left == -1)
            return left;
        int right = dfs(left, list);
        return right;
    }
}