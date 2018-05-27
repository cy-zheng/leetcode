import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        // IMPORTANT
        String[] list = paragraph.split("[!?',;.\\s]\\s*");
        Set<String> banSet = new HashSet<>();
        for (String b : banned) {
            banSet.add(b.toLowerCase());
        }
        String result = "";
        int count = -1;
        for (String s : list) {
            if (s.length() == 0 || banSet.contains(s.toLowerCase()))
                continue;
            map.put(s.toLowerCase(), map.getOrDefault(s.toLowerCase(), 0) + 1);
            if (map.get(s.toLowerCase()) > count) {
                count = map.get(s.toLowerCase());
                result = s.toLowerCase();
            }
        }
        return result;
    }
}
