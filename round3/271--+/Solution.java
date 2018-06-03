import java.util.*;

public class Codec {
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(formatInteger(str.length()));
            sb.append(str);
        }
        return sb.toString();
    }
    
    private String formatInteger(int target) {
        return String.format("%010d", target);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int length = Integer.parseInt(s.substring(index, index + 10));
            result.add(s.substring(index + 10, index + length + 10));
            index = index + length + 10;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
