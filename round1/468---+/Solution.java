class Solution {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0)
            return "Neither";
        if (IP.indexOf('.') != -1)
            return isIPv4(IP) ? "IPv4" : "Neither";
        else
            return isIPv6(IP) ? "IPv6" : "Neither";
    }
    
    
    private boolean isIPv4(String IP) {
        int count = 0;
        for (int i = 0; i < IP.length(); i++) {
            if ((IP.charAt(i) < '0' || IP.charAt(i) > '9') && IP.charAt(i) != '.')
                return false;
            if (IP.charAt(i) == '.')
                count++;
        }
        if (count != 3)
            return false;
        String[] nums = IP.split("\\.");
        if (nums.length != 4)
            return false;
        
        for (String s : nums) {
            if (s.equals("") || (s.charAt(0) == '0' && s.length() > 1))
                return false;
            try {
                int n = Integer.parseInt(s);
                if (n < 0 || n > 255)
                    return false;
            }
            catch (Exception e) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isIPv6(String IP) {
        int count = 0;
        for (int i = 0; i < IP.length(); i++) {
            if ((IP.charAt(i) < '0' || IP.charAt(i) > '9') && IP.charAt(i) != ':' 
                    && (IP.charAt(i) < 'a' || IP.charAt(i) > 'f') && (IP.charAt(i) < 'A' || IP.charAt(i) > 'F'))
                return false;
            if (IP.charAt(i) == ':')
                count++;
        }
        if (count != 7)
            return false;
        String[] nums = IP.split(":");
        if (nums.length != 8)
            return false;
        
        for (String s : nums) {
            if (s.equals("") || s.length() > 4)
                return false;
        }
        return true;
    }
}