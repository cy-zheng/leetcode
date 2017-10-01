/*
    O(n)时间遍历树，TLE
*/

class Solution {
    public int findKthNumber(int n, int k) {
        int t = 1;
        for (int i = 0; i < k - 1; i++)
            t = getNext(t, n);
        return t;
    }
    
    private int getNext(int t, int n) {
        if (t * 10L <= n)
            return t * 10;
        else if (t + 1 <= n && t / 10 == (t + 1) / 10)
            return t + 1;
        else {
            int r = t / 10 + 1;
            while (r % 10 == 0)
                r /= 10;
            return r;
        }
    }
    
}

/*
    想成10叉树的先序遍历
    参考：http://bgmeow.xyz/2017/01/02/LeetCode-440/
*/


class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            // 计算 lexicographical 差
            int steps = calStep(n, curr, curr + 1);
            // 差小于 k
            if (steps <= k) {
                curr++;
                k = k - steps;
            // 差大于 k，lexicographical 加 1 ，即自然顺序 *10
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
    public int calStep(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            // 如果 n2 比 n + 1 大，则这一层里到 n2 为止的节点都存在
            if (n2 > n + 1) {
                steps += n + 1 - n1;
            } else {
                steps += n2 - n1;
            }
            // 到下一层（n1 和 n2 始终同一层）
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}