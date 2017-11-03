import java.util.*;

class Solution {
    public int distributeCandies(int[] candies) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int c : candies) {
            if (!set.contains(c)) {
                result++;
                set.add(c);
            }
        }
        
        return Math.min(result, candies.length / 2);
    }
}