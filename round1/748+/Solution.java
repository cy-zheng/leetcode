class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] counter = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char curr = handleChar(licensePlate.charAt(i));
            if (curr != '0')
                counter[curr - 'a']++;
        }

        int currLength = Integer.MAX_VALUE;
        String result = null;

        for (String word : words) {
            if (word.length() >= currLength)
                continue;
            if (hasAllLetter(word, counter)) {
                currLength = word.length();
                result = word;
            }
        }
        return result;
    }

    private boolean hasAllLetter(String word, int[] counter) {
        int[] counter2 = new int[26];
        for (int i = 0; i < word.length(); i++) {
            counter2[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i] > counter2[i])
                return false;
        }
        return true;
    }

    private char handleChar(char c) {
        if (c >= 'a' && c <= 'z')
            return c;
        if (c >= 'A' && c <= 'Z')
            return (char) (c - 'A' + 'a');
        return '0';
    }
}
