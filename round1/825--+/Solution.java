import java.util.*;

class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int start = 0, end = 0, result = 0;
        for (int i = 0; i < ages.length; i++) {
            while (end < ages.length && ages[end] <= ages[i])
                end += 1;
            while (start < end && ages[start] <= 0.5 * ages[i] + 7.0001) 
                start += 1;
            if (start > i)
                result += end - start;
            else
                result += end - start - 1;
        }
        return result;
    }
}
