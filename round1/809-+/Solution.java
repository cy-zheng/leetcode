/*
    迷
*/

class Solution {
    public int expressiveWords(String S, String[] words) {
        int result = 0;
        for (String word : words) {
            if (canExtend(S, word)) 
                result += 1;
        }
        return result;
    }
    
    private boolean canExtend(String source, String target) {
        if (target.length() > source.length())
            return false;
        int left = 0, right = 0;
        int sourceIndex = 0;
        while (left < target.length() && right < target.length()) {
            while (right < target.length() && target.charAt(left) == target.charAt(right)) {
                right += 1;
            }
            int preIndex = sourceIndex;
            while (sourceIndex < source.length() && source.charAt(sourceIndex) == target.charAt(left))
                sourceIndex += 1;
            if (sourceIndex - preIndex == 2 && right - left != 2)
                return false;
            if (sourceIndex - preIndex < right - left)
                return false;
            left = right;
        }
        return sourceIndex == source.length();
    }
}
