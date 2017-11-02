import java.util.*;

class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        String[] seg = s.split(" ");
        for (String t : seg) 
            list.add(new StringBuilder(t).reverse().toString());
        
        StringBuilder sb = new StringBuilder();
        for (String t : list) {
            if (sb.length() > 0)
                sb.append(" ");
            sb.append(t);
        }
        
        return sb.toString();
    }
}