import java.util.*;

class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        char[] list = T.toCharArray();
        sort(list, 0, list.length - 1, map);
        return new String(list);
    }
    
    private void sort(char[] list, int start, int end, Map<Character, Integer> map) {
        if (start >= end)
            return;
        
        int i = start, j = end;
        char pivot = list[(start + end) / 2];
        
        while (i <= j) {
            while (i <= j && map.getOrDefault(list[i], 100) < map.getOrDefault(pivot, 100)) i++;
            while (i <= j && map.getOrDefault(list[j], 100) > map.getOrDefault(pivot, 100)) j--;
            if (i <= j) {
                char tmp = list[i];
                list[i] = list[j];
                list[j] = tmp;
                i++;
                j--;
            }
        }
        
        sort(list, start, j, map);
        sort(list, i, end, map);
    }
}
