import java.util.*;

class Solution {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        Set<Integer> bulls = new HashSet<>();
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
                bulls.add(i);
            }
            else {
                if (chars.containsKey(secret.charAt(i))) {
                    chars.put(secret.charAt(i), chars.get(secret.charAt(i)) + 1);
                }
                else {
                    chars.put(secret.charAt(i), 1);
                }
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (bulls.contains(i))
                continue;
            if (chars.containsKey(guess.charAt(i))) {
                b++;
                chars.put(guess.charAt(i), chars.get(guess.charAt(i)) - 1);
                if (chars.get(guess.charAt(i)) == 0)
                    chars.remove(guess.charAt(i));
            }
        }   
        return a + "A" + b + "B";
    }
}