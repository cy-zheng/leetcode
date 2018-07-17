import java.util.*;

class Solution {
    
    private int N;
    private int[] blacklist;
    private Random rand;

    public Solution(int N, int[] blacklist) {
        this.N = N;
        this.blacklist = blacklist;
        Arrays.sort(this.blacklist);
        for (int i = 0; i < blacklist.length; i++) {
            blacklist[i] -= i;
        }
        this.rand = new Random();
    }
    
    public int pick() {
        int result = this.rand.nextInt(N - this.blacklist.length);
        if (blacklist.length == 0)
            return result;
        int left = 0, right = blacklist.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (blacklist[mid] <= result)
                left = mid;
            else
                right = mid;
        }
        if (blacklist[left] > result)
            return result + left;
        else if (blacklist[right] > result) 
            return result + right;
        else 
            return result + blacklist.length;
    }
}  

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
