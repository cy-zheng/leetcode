import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        
        int[] lastIndex = new int[26];
        for (int i = 0; i < lastIndex.length; i++) {
            lastIndex[i] = -1;
        }
        // 记录每个字母最后的一个下标
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        // 类似于jump game
        int last = -1;
        int pre = -1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastIndex[S.charAt(i) - 'a']);
            if (last == i) {
                if (pre == -1) {
                    result.add(i + 1);
                } else {
                    result.add(i - pre);
                }
                pre = i;
            }
        }
        return result;
    }
}
