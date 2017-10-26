import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        char[] row1 = new char[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] row2 = new char[] {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] row3 = new char[] {'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : row1)
            map.put(c, 1);
        for (char c : row2)
            map.put(c, 2);
        for (char c : row3)
            map.put(c, 3);
        
        List<String> result = new ArrayList<>();
        for (String s : words) {
            int row = -1;
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                char c = (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ? s.charAt(i) : (char) (s.charAt(i) - 'A' + 'a');
                if (row == -1 || row == map.get(c))
                    row = map.get(c);
                else {
                    flag = false;
                    break;
                }
            }
            
            if (flag) 
                result.add(s);
        }
        
        String[] r = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}