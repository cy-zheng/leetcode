/*
    dp的O(n)解法超时，解有规律
*/

class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}