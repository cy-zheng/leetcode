/*
    不能一个一个的判断，会超时，需要一次跳过去一些，然后判断是不是在空格上，是继续，不是就回退
    class Solution {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            int i = 0, j = 0, index = 0;
            int result = 0;
            while (i < rows) {
                // a space after other word
                if (j != 0)
                    j += 1;
                // add word to this line
                if (j + sentence[index].length() <= cols) {
                    j += sentence[index].length();
                    index += 1;
                } 
                // add word to next line
                else {
                    j = 0;
                    i += 1;
                }
                // add result
                if (index == sentence.length) {
                    index = 0;
                    result += 1;
                }
            }
            return result;
        }
    }
*/
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        
        return start / s.length();
    }
}
