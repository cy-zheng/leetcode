class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        boolean cnt = false;
        boolean aFlag, bFlag;
        for (int i = 0; i < 32; i++) {
            aFlag = (a & (1 << i)) != 0;
            bFlag = (b & (1 << i)) != 0;
            if (aFlag ^ bFlag ^ cnt)
                result |= (1 << i);
            cnt = (aFlag && bFlag && !cnt) || (!aFlag && bFlag && cnt) || (aFlag && !bFlag && cnt) || (aFlag && bFlag && cnt);
        }
        return result;
    }
}