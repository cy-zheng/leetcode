/*
    使用char[]保存前缀，避免多次构造String对象
*/

import java.util.*;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs, new Comparator<String>(){
           public int compare(String s1, String s2){
               return s1.length() - s2.length();
           } 
        });
        char[] words = new char[strs[0].length()];
        int end = strs[0].length();
        
        
        for (int i = 0; i < strs[0].length(); i++) {
            words[i] = strs[0].charAt(i);
        }
        
        for (int i = 1; i< strs.length; i++) {
            for (int j = 0; j < end; j++) {
                if (words[j] != strs[i].charAt(j)) {
                    end = j;
                    break;
                }
            }
        }
        return new String(words, 0, end);
    }
}