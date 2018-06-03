import java.util.*;

class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return dfs(map, set, pattern, str, 0, 0);
    }

    private boolean dfs(Map<Character, String> map, Set<String> set, String pattern, String str, int pIndex, int sIndex) {
        if (pIndex >= pattern.length() && sIndex >= str.length())
            return true;
        else if (pIndex >= pattern.length() || sIndex >= str.length())
            return false;
        if (map.containsKey(pattern.charAt(pIndex))) {
            if (str.indexOf(map.get(pattern.charAt(pIndex)), sIndex) != sIndex)
                return false;
            else
                return dfs(map, set, pattern, str, pIndex + 1, sIndex + map.get(pattern.charAt(pIndex)).length());
        }
        boolean result = false;
        for (int i = sIndex + 1; i <= str.length(); i++) {
            if (set.contains(str.substring(sIndex, i)))
                continue;
            map.put(pattern.charAt(pIndex), str.substring(sIndex, i));
            set.add(str.substring(sIndex, i));
            result |= dfs(map, set, pattern, str, pIndex + 1, sIndex + map.get(pattern.charAt(pIndex)).length());
            map.remove(pattern.charAt(pIndex));
            set.remove(str.substring(sIndex, i));
        }
        return result;
    }
}
