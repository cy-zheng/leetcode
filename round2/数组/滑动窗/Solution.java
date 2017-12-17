/*
    leetcode 3
    明确left，right指针的意义
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int left = 0;
        int right = 0;
        int max = 0;
        boolean[] flag = new boolean[256];
        while (right < s.length()){
            if (!flag[s.charAt(right)]){
                flag[s.charAt(right)] = true;
                max = Math.max(max, right - left + 1);
                right++;
            }
            else{
                while (flag[s.charAt(right)] && left < right){
                    flag[s.charAt(left)] = false;
                    left++;
                }
            }
        }
        
        return max;
    }
}
