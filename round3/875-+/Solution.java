class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        
        int left = 1, right = max;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (canEat(piles, mid, H))
                right = mid;
            else
                left = mid;
        }
        if (canEat(piles, left, H))
            return left;
        return right;
    }
    
    private boolean canEat(int[] piles, int K, int H) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / K + (pile % K == 0 ? 0 : 1);
        }
        return hours <= H;
    }
}
