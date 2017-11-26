class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int  i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) res.add(i);
        }
        return res;
    }

    private boolean isSelfDividingNumber(int i) {
        int a = i;
        while (a > 0) {
            int b = a % 10;
            if (b == 0) return false;
            if (i % b != 0) return false;
            a = a / 10;
        }
        return true;
    }
}
