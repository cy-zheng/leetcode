import java.util.*;

class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> result = new ArrayList<>();
        S = S.substring(1, S.length() - 1);
        for (int i = 1; i < S.length(); i++) {
            split(result, S, i);
        }
        return result;
    }
    
    private void split(List<String> result, String s, int index) {
        String left = s.substring(0, index);
        String right = s.substring(index, s.length());
        List<String> leftList = validNum(left);
        List<String> rightList = validNum(right);
        for (String l : leftList) {
            for (String r : rightList) {
                result.add("(" + l + ", " + r + ")");
            }
        }
    }
    
    private List<String> validNum(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(s);
            return result;
        }
        if (s.charAt(s.length() - 1) == '0') {
            if (s.charAt(0) != '0') {
                result.add(s);
            }
            return result;
        }
        if (s.charAt(0) == '0') {
            result.add("0." + s.substring(1, s.length()));
            return result;
        }
        result.add(s);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < sb.length(); i++) {
            sb.insert(i, '.');
            result.add(sb.toString());
            sb.deleteCharAt(i);
        }
        return result;
    }
}
