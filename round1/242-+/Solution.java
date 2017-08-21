class Solution {
    public boolean isAnagram(String s, String t) {
        int[] slist = new int[26];
        int[] tlist = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            slist[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            tlist[t.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (slist[i] != tlist[i])
                return false;
        }
        return true;
    }
}