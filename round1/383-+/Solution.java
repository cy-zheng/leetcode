/*
    不需要考虑s2与s1之间的顺序关系，s2包含s1全部字母就行
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null)
            return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map1.containsKey(ransomNote.charAt(i)))
                map1.put(ransomNote.charAt(i), 0);
            map1.put(ransomNote.charAt(i), map1.get(ransomNote.charAt(i)) + 1);
        }
        
        for (int i = 0; i < magazine.length(); i++) {
            if (!map2.containsKey(magazine.charAt(i)))
                map2.put(magazine.charAt(i), 0);
            map2.put(magazine.charAt(i), map2.get(magazine.charAt(i)) + 1);
        }
        
        for (char key : map1.keySet()) {
            if (!map2.containsKey(key) || map2.get(key) < map1.get(key))
                return false;
        }
        
        return true;
    }
}