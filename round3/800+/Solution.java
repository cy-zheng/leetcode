import java.util.*;

class Solution {
    public String similarRGB(String color) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put((char) (i + '0'), i);
        }
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
        String result = "";
        int diff = Integer.MAX_VALUE;
        for (char r : map.keySet()) {
            for (char g : map.keySet()) {
                for (char b : map.keySet()) {
                    int ndiff = (int) (Math.pow(map.get(r) * 16 + map.get(r) 
                                         - map.get(color.charAt(1)) * 16 - map.get(color.charAt(2)), 2)
                            + Math.pow(map.get(g) * 16 + map.get(g) 
                                       - map.get(color.charAt(3)) * 16 - map.get(color.charAt(4)), 2)
                            + Math.pow(map.get(b) * 16 + map.get(b) 
                                       - map.get(color.charAt(5)) * 16 - map.get(color.charAt(6)), 2));
                    if (ndiff < diff) {
                        diff = ndiff;
                        result = "#" + r + r + g + g + b + b;
                    }a
                }
            }
        }
        return result;
    }
}
