class Solution {
    public boolean hasAlternatingBits(int n) {
        for (int i = 1; i < 31; i++) {
            if ((1 << i) > n)
                break;
            int n1 = n & (1 << i);
            int n2 = n & (1 << (i - 1));
            if (n1 == 0 && n2 == 0)
                return false;
            if (n1 != 0 && n2 != 0)
                return false;
        }
        return true;
    }
}
