class Solution {
    public int findComplement(int num) {
        int result = 0;
        boolean flag = false;
        for (int i = 31; i >= 0; i--) {
            int tmp = num & (1 << i);
            if (flag || tmp != 0) {
                flag = true;
                if (tmp == 0) {
                    result |= 1 << i;
                }
            }
        }
        return result;
    }
}