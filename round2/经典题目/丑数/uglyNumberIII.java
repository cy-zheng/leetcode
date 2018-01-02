/*
    leetcode 313
    丑数进阶版
*/

class Solution {
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[pointers[j]] * primes[j] < min) {
                    min = ugly[pointers[j]] * primes[j];
                    minIndex = j;
                }
                else if (ugly[pointers[j]] * primes[j] == min) {
                    pointers[j]++;
                }
            }
            ugly[i] = min;
            pointers[minIndex]++;
        }
        return ugly[n - 1];
    }
}
