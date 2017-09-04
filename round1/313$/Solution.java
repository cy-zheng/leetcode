/*
    很巧妙的一道题，复杂度O(KN)
    假如primes有三个元素，丑陋数序列可以拆分为下面3个子列表：
    (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
    (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
    (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
    要求的丑陋数就是从已经生成的序列中取出来的，我们每次都从三个列表中取出当前最小的那个加入序列
    所以我们使用一个pointer计算当前三个序列走到哪里了
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
                    pointers[j]++;   // 遇到重复无脑+1即可，重复元素不会被计入ugly，直接指向下一个元素
                }
            }
            ugly[i] = min;
            pointers[minIndex]++;   // minIndex对应的pointer后移
        }
        return ugly[n - 1];
    }
}