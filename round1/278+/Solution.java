/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) 
                right = mid;
            else
                left = mid;
        }
        
        if (isBadVersion(left))
            return left;
        return right;
    }
}