class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        
        int min = 0;
        int max = citations.length - 1;
        
        while (min + 1 < max) {
            int mid = (max - min) / 2 + min;
            if (citations[mid] <= citations.length - mid)
                min = mid;
            else
                max = mid;
        }
        
        if (citations[min] >= citations.length - min)
            return citations.length - min;
        if (citations[max] >= citations.length - max)
            return citations.length - max;
        return 0;
    }
}