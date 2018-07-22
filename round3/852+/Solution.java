class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1])
                left = mid;
            else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1])
                right = mid;
            else
                return mid;
        }
        if (A[left - 1] < A[left] && A[left] > A[left + 1])
            return left;
        if (A[right - 1] < A[right] && A[right] > A[right + 1])
            return right;
        return -1;
    }
}
