class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int c = 0;
        while (i >= 0 && j >= 0) {
            int r = c + (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0');
            c = r / 10;
            r = r % 10;
            sb.insert(0, Integer.toString(r));
        }
        
        while (i >= 0) {
            int r = c + (num1.charAt(i--) - '0');
            c = r / 10;
            r = r % 10;
            sb.insert(0, Integer.toString(r));
        }
        
        while (j >= 0) {
            int r = c + (num2.charAt(j--) - '0');
            c = r / 10;
            r = r % 10;
            sb.insert(0, Integer.toString(r));
        }
        
        if (c != 0) 
            sb.insert(0, Integer.toString(c));
        
        return sb.toString();
    }
}