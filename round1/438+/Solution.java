import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count1 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count1[p.charAt(i) - 'a']++;
        }
        int[] count2 = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            count2[s.charAt(i) - 'a']++;
            if (i >= p.length() - 1) {
                if (i > p.length() - 1)
                    count2[s.charAt(i - p.length()) - 'a']--;
                if (isAnagram(count1, count2))
                    result.add(i - p.length() + 1);
            }
            
        }
        return result;
    }
    
    private boolean isAnagram(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count2[i] != count1[i])
                return false;
        }
        return true;
    }
}