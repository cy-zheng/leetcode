/*
    For example, given IDIIDD we start with sorted sequence 1234567
    Then for each k continuous D starting at index i we need to reverse [i, i+k] portion of the sorted sequence.

    IDIIDD
    1234567 // sorted
    1324765 // answer
    
    想想还是很好理解的，因为题目要求返回字典序最小的字符串，那么必须从1，2，3，……，n来构造，出现的字符串会最小。
    每段连续的D，不可能包含之后连续D的字符，越靠前的D段，通过反序即可拿到最小的字符。
*/

class Solution {
    public int[] findPermutation(String s) {
        int n = s.length(), arr[] = new int[n + 1]; 
        for (int i = 0; i <= n; i++) arr[i] = i + 1; // sorted
        for (int h = 0; h < n; h++) {
            if (s.charAt(h) == 'D') {
                int l = h;
                while (h < n && s.charAt(h) == 'D') h++;
                reverse(arr, l, h); 
            }   
        }   
        return arr;
    }   

    private void reverse(int[] arr, int l, int h) {
        while (l < h) {
            arr[l] ^= arr[h];
            arr[h] ^= arr[l];
            arr[l] ^= arr[h];
            l++; h--;
        }   
    }
}
