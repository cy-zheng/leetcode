import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, result = 0;
        while (left <= right) {
            while (left < right && people[left] + people[right] > limit) {
                right -= 1;
                result += 1;
            }
            if (left < right && people[left] + people[right] <= limit) {
                left += 1;
                right -= 1;
                result += 1;
            }
            else if (left == right) {
                result += 1;
                left += 1;
                right -= 1;
            }
        }
        return result;
    }
}
