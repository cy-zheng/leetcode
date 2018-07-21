/*
    Can you do it in O(N) time and O(1) space?
    I believe you have one difficulty here: When we meet a char, we are not sure if it will be still there or be deleted.

    However, we can do a back string compare (just like the title of problem).
    If we do it backward, we meet a char and we can be sure this char won't be deleted.
    If we meet a '#', it tell us we need to skip next lowercase char.
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        for (int i = S.length() - 1, j = T.length() - 1;; i--, j--) {
            for (int b = 0; i >= 0 && (b > 0 || S.charAt(i) == '#'); --i) 
                b += S.charAt(i) == '#' ? 1 : -1;
            for (int b = 0; j >= 0 && (b > 0 || T.charAt(j) == '#'); --j) 
                b += T.charAt(j) == '#' ? 1 : -1;
            if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) 
                return i == -1 && j == -1;
        }
    }
}
