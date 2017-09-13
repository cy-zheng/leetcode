class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels = new StringBuilder();
        StringBuilder others = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u' 
                    || curr == 'A' || curr == 'E' || curr == 'I' || curr == 'O' || curr == 'U') {
                others.append('a');
                vowels.append(curr);
            }
            else 
                others.append(curr);
        }
        vowels = vowels.reverse();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = others.charAt(i);
            if (curr == 'a') {
                result.append(vowels.charAt(j));
                j++;
            }
            else
                result.append(curr);
        }
        return result.toString();
    }
}