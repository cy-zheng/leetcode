/*
    双序列dp
*/

/**
 * dp[i][j] = a[i] == b[j] ? dp[i + 1][j + 1] : 0;
 * dp[i][j] : max lenth of common subarray start at a[i] & b[j];
 */

class Solution {
    public int findLength(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                max = Math.max(max, dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0);
        return max;        
    }
}

/*
另外可以学习HashMap的解法，一个map中保存了A中相同数字所有的下标
然后遍历B，和A中相同数字的所有下标开始比较

class Solution {
    public int findLength(int[] A, int[] B) {
        int l1 = A.length, l2 = B.length, ans = 0;
        if (l1 == 0 || l2 == 0)
            return 0;        
        HashMap < Integer, List < Integer >> map = new HashMap < > ();
        List < Integer > list;
        for (int i = 0; i < l1; i++) {
            int n = A[i];
            list = map.getOrDefault(n, new ArrayList<Integer>());
            list.add(i);
            map.put(n, list);
        }
        
        for (int i = 0; i < l2 && l2-i > ans; i++) {
            int n = B[i];
            if (map.containsKey(n)){
                list = map.get(n);
                for (int m: list) {
                    if (l1 - m < ans)
                        break;                
                    int count = 1, k = m + 1;
                    for (int j = i + 1; j < l2 && k < l1; j++, k++) {
                        if (B[j] == A[k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    ans = Math.max(ans, count);                
                }
            }
        }

        return ans;
    }
}
*/
