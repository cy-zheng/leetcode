class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (letters[mid] > target)
                right = mid;
            else
                left = mid;
        }
        if (letters[left] > target)
            return letters[left];
        if (letters[right] > target)
            return letters[right];
        return letters[0];
    }
}
