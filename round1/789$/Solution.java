/*
    比较0，0到target的距离和g到target的距离。
    如果g可以先于你到达target，那么必输。
    https://leetcode.com/problems/escape-the-ghosts/discuss/116678/Why-interception-in-the-middle-is-not-a-good-idea-for-ghosts.
*/

class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] t) {
        int d = Math.abs(t[0]) + Math.abs(t[1]);
        for (int[] g: ghosts)
            if (d >= Math.abs(t[0] - g[0]) + Math.abs(t[1] - g[1]))
                return false;
        return true;
    }
}
