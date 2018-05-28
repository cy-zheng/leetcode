class Solution {
    public String maskPII(String S) {
        if (S.indexOf('@') != -1) {
            return convertEmail(S);
        }
        return convertPhoneNumber(S);
    }
    
    private String convertEmail(String s) {
        s = s.toLowerCase();
        String[] list = s.split("@");
        String first = list[0];
        StringBuilder sb = new StringBuilder();
        sb.append(first.charAt(0));
        for (int i = 0; i < 5; i++) {
            sb.append('*');
        }
        sb.append(first.charAt(first.length() - 1));
        return sb.toString() + "@" + list[1];
    }
    
    private String convertPhoneNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9')
                continue;
            sb.append(c);
        }
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= sb.length() - 4; i--)
            result.insert(0, sb.charAt(i));
        int index = sb.length() - 5;
        while (index >= 0) {
            result.insert(0, '-');
            for (int i = 0; i < 3; i++) {
                result.insert(0, '*');
                index -= 1;
                if (index < 0)
                    break;
            }
        }
        if (result.charAt(0) == '-')
            result.deleteCharAt(0);
        if (sb.length() > 10)
            result.insert(0, '+');
        return result.toString();
    }
}
