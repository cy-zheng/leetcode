public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        
        StringBuilder sb = new StringBuilder();
        String[] list = s.split(" ");
        
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i].length() > 0){
                if (sb.length() != 0) sb.append(" ");
                sb.append(list[i]);
            }
        }
        return sb.toString();
    }
}