/*
    还要判断下一个能不能放
*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0)
            return false;
        int i = 0;
        boolean preIsEmpty = true;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1)
                preIsEmpty = false;
            else {
                if (!preIsEmpty)
                    preIsEmpty = true;
                else {
                    if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                        preIsEmpty = false;
                        n--;
                    }
                    else {
                        preIsEmpty = true;
                    }
                }
            }
            i++;
        }
        
        return n <= 0;
    }
}
