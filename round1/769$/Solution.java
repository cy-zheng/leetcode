/*
    Google 面试题
*/

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0, max = 0, idx = 0;
        
        while(idx < arr.length) {
            max = arr[idx];
            while(idx < max) {
                idx++;
                max = Math.max(max, arr[idx]);
            }
            idx++;
            res++;
        }
        
        return res;
    }
}
