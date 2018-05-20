/*
    local与global相等的条件是，每个数字只有可能和它之后的第一个数字存在逆序关系。
    所以比较它之后的第2~N个数字，存在逆序关系，local与global就不相等。
*/

class Solution {
    public boolean isIdealPermutation(int[] A) {
        int min = Integer.MAX_VALUE;
        if (A == null || A.length <= 2)
            return true;
        for (int i = A.length - 1; i >= 2; i--) {
            min = Math.min(min, A[i]);
            if (min < A[i - 2])
                return false;
        }
        return true;
    }
}
