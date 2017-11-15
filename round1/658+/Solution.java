import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] > x)
                right = mid;
            else
                left = mid;
        }
        
        int dist = Integer.MAX_VALUE;
        int index = -1;
        if (left - 1 > 0 && Math.abs(arr[left - 1] - x) < dist) {
            dist = Math.abs(arr[left - 1] - x);
            index = left - 1;
        }
        if (Math.abs(arr[left] - x) < dist) {
            dist = Math.abs(arr[left] - x);
            index = left;
        }
        if (Math.abs(arr[right] - x) < dist) {
            dist = Math.abs(arr[right] - x);
            index = right;
        }
        if (right + 1 < arr.length && Math.abs(arr[right + 1] - x) < dist) {
            dist = Math.abs(arr[right + 1] - x);
            index = right + 1;
        }
        
        
        left = right = index;
        while (right - left + 1 < k) {
            if (left > 0 && right < arr.length - 1) {
                if (Math.abs(arr[right + 1] - x) < Math.abs(arr[left - 1] - x))
                    right++;
                else
                    left--;
            }
            else if (left > 0)
                left--;
            else
                right++;
        }
        
        for (int i = left; i <= right; i++)
            result.add(arr[i]);
        return result;
    }
}
