class Result {
    int distToTarget, distToLeaf, nearLeaf;
    public Result(int distToTarget, int distToLeaf, int nearLeaf) {
        this.distToTarget = distToTarget;
        this.distToLeaf = distToLeaf;
        this.nearLeaf = nearLeaf;
    }
}

public class Solution {

    private int result = -1;
    private int dist = Integer.MAX_VALUE;

    public int findClosestLeaf(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private Result dfs(TreeNode root, int k) {
        if (root.left == null && root.right == null) {
            // 当前节点是叶子节点，而且val == k，那么result为当前节点
            if (root.val == k) {
                result = k;
                dist = 0;
                return new Result(0, 0, root.val);
            }
            // 当前节点到target距离无穷大
            else {
                return new Result(Integer.MAX_VALUE, 0, root.val);
            }
        }
        else {
            // 左右两个孩子的结果
            Result left, right;
            if (root.left != null)
                left = dfs(root.left, k);
            else
                left = new Result(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);
            if (root.right != null)
                right = dfs(root.right, k);
            else
                right = new Result(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);
            // 当前节点val == k，那么选择左右一个到叶子近的
            if (root.val == k) {
                if (left.distToLeaf > right.distToLeaf) {
                    result = right.nearLeaf;
                    dist = right.distToLeaf + 1;
                    return new Result(0, right.distToLeaf + 1, right.nearLeaf);
                }
                else {
                    result = left.nearLeaf;
                    dist = left.distToLeaf + 1;
                    return new Result(0, left.distToLeaf + 1, left.nearLeaf);
                }
            }
            // 左右节点已经发现了k，那么考虑绕圈的情况
            else if (left.distToTarget != Integer.MAX_VALUE || right.distToTarget != Integer.MAX_VALUE) {
                if (left.distToTarget != Integer.MAX_VALUE) {
                    // 右节点存在叶子，而且绕一圈比dist小
                    if (right.distToLeaf != Integer.MAX_VALUE && left.distToTarget + 1 + right.distToLeaf < dist) {
                        result = right.nearLeaf;
                        dist = left.distToTarget + 1 + right.distToLeaf;
                        return new Result(left.distToTarget + 1, right.distToLeaf + 1, right.nearLeaf);
                    }
                    else
                        return new Result(left.distToTarget + 1, left.distToLeaf + 1, left.nearLeaf);
                }
                // 右节点同左节点
                else {
                    if (left.distToLeaf != Integer.MAX_VALUE && right.distToTarget + 1 + left.distToLeaf < dist) {
                        result = left.nearLeaf;
                        dist = right.distToTarget + 1 + left.distToLeaf;
                        return new Result(right.distToTarget + 1, left.distToLeaf + 1, left.nearLeaf);
                    }
                    else
                        return new Result(right.distToTarget + 1, right.distToLeaf + 1, right.nearLeaf);
                }
            }
            else {
                // 返回叶子相关信息
                if (left.distToLeaf > right.distToLeaf) {
                    return new Result(Integer.MAX_VALUE, right.distToLeaf + 1, right.nearLeaf);
                }
                else {
                    return new Result(Integer.MAX_VALUE, left.distToLeaf + 1, left.nearLeaf);
                }
            }
        }
    }
}
