/*
    先从左到右扫描一遍，使得右边比左边得分高的小朋友糖果数比左边多。
    再从右到左扫描一遍，使得左边比右边得分高的小朋友糖果数比右边多。
*/

class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
            else
                candies[i] = 1;
        }
        
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
                candies[i] = candies[i + 1] + 1;
        }
        
        int result = 0;
        for (int c : candies)
            result += c;
        return result;
    }
}