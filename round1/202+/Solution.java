import java.util.*;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int tmp;
        while (n != 1) {
            if (visited.contains(n))
                return false;
            else {
                visited.add(n);
                tmp = 0;
                while (n != 0) {
                    tmp += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = tmp;
            }
        }
        return true;
    }
}