import java.util.*;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> s = new HashSet<>();
        for (String word : words) {
            String code = "";
            for (char c : word.toCharArray()) 
                code += d[c - 'a'];
            s.add(code);
        }
        return s.size();
    }
}
