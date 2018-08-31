/*
    注意需要考虑相同字符串的情况，比如aaaa和aaaa是一个group的，abc和abc也是一个group的。
*/

class Solution {
    public int numSimilarGroups(String[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != null) {
                result += 1;
                String curr = A[i];
                A[i] = null;
                dfs(A, curr);
            }
        }
        return result;
    }
    
    private void dfs(String[] list, String curr) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && sameGroup(list[i], curr)) {
                String next = list[i];
                list[i] = null;
                if (!curr.equals(next))
                    dfs(list, next);
            }
        }
    }
    
    private boolean sameGroup(String s1, String s2) {
        if (s1.equals(s2)) 
            return true;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff += 1;
        }
        return diff == 2;
    }
}
