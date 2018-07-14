/*
    Let D(N) be the required answer. The recursion for the number of derangements of N is: D(N) = (N-1) * (D(N-1) + D(N-2)). With this recursion in hand, the problem becomes similar to finding the N-th fibonacci number.

    To prove it, suppose there are people and hats labelled 1...N. We want the number of ways to put a hat on each person such that no person is wearing their hat. The first person has N-1 choices to put on a hat, say he wears hat X. Now consider what hat person X is wearing. Either he takes hat 1, and we have D(N-2) ways to arrange the remaining hats among people; or he doesn't take hat 1, which if we relabelled it as hat X, would have D(N-1) ways to arrange the remaining hats.
    
    A little more explanation:

    For the original D(n-1) problem, each person in 1 -- n-1 may get his own hat, so each person (including person x) only have n-2 choices;

    For the D(n) problem:
    While after the first person pick the Hat X, there are n-1 persons left , all persons left other than X have n-2 choices, and person X have n-1 choices;

    And for person X: if x pick some hat other than hat_1, means X also only have n-2 choices. n-1 persons and each has n-2 choices == D(n-1) problem;
    if x pick hat_1, than there are only n-2 persons left, and each has n-3 choices == D(n-2) prolbem;
*/

class Solution {
    public int findDerangement(int n) {
        if(n <= 1) return 0;
        long[] dp = new long[n + 1];
        long mod = 1000000007;
        dp[2] = 1;
        for(int i = 3; i < dp.length; i++){
            dp[i] = (long)(i - 1) * (dp[i - 1] + dp[i - 2]) % mod;
        }
        return (int)dp[dp.length - 1];
    }
}
