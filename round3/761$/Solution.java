/*
    http://www.cnblogs.com/grandyang/p/8606024.html
*/

import java.util.*;

class Solution {
    public String makeLargestSpecial(String S) {
        int cnt = 0, index = 0;
        List<String> v = new ArrayList<>();
        String res = "";
        for (int j = 0; j < S.length(); j++) {
            cnt += (S.charAt(j) == '1') ? 1 : -1;
            if (cnt == 0) {
                // "1" + dfs + "0"是为了解决(())情况下的stackoverflow
                // 每一个合法的字符串，肯定是1开头，0结尾
                v.add("1" + makeLargestSpecial(S.substring(index + 1, j)) + "0");
                index = j + 1;
            }
        }
        Collections.sort(v);
        for (int i = v.size() - 1; i >= 0; i--) 
            res += v.get(i);
        return res;
    }
}
