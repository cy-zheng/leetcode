/*
    检查源串是否含有目标串的一个排列（任意打乱顺序）
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) 
            count[s1.charAt(i) - 'a']++;
        
        int left = 0, right = 0;
        while (left < s2.length() && right < s2.length()) {
            count[s2.charAt(right) - 'a']--;
            while (count[s2.charAt(right) - 'a'] < 0)
                count[s2.charAt(left++) - 'a']++;
            if (checkCount(count))
                return true;
            right++;    
        }
        return false;
    }
    
    private boolean checkCount(int[] count) {
        for (int i : count) {
            if (i != 0)
                return false;
        }
        return true;
    }
}