class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] += 1;
        }
        
        boolean hasSingle = false;
        for (int i : count) {
            if (i % 2 == 1) {
                if (hasSingle)
                    return false;
                else
                    hasSingle = true;
            }
        }
        return true;
    }
}
