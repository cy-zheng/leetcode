/*
    N can be expressed as k + 1, k + 2, ..., k + i, therefore

    N = k * i + (i + 1) * i / 2 =>
    N - (i + 1) * i / 2 = k * i

    Since N can always be written as N, we can start from i = 2, ans = 1.
*/

class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 1;
        for (int i = 2; i * (i + 1) / 2 <= N; ++i) {
            if ((N - i * (i + 1) / 2) % i == 0) 
                ans += 1;
        }
        return ans;
    }
}
