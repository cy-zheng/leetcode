import java.util.*;

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == '-')
                continue;
            else if (c >= 'a' && c <= 'z') 
                c = (char) (c - 'a' + 'A');
            
            sb.append(c);
            if (sb.length() == K) {
                list.add(sb.reverse().toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() != 0) {
            list.add(sb.reverse().toString());
            sb = new StringBuilder();
        }
        
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i != 0)
                sb.append('-');
        }
        return sb.toString();
    }
}