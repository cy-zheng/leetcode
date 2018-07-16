class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;
        while (reader.get(right) <= target)
            right *= 2;
        
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (reader.get(mid) <= target)
                left = mid;
            else
                right = mid;
        }
        if (reader.get(left) == target)
            return left;
        if (reader.get(right) == target)
            return right;
        return -1;
    }
}
