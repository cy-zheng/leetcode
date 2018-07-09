import java.util.*;

class Solution {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(Integer.toString(i));
        }
        return helper(list);
    }
    
    private String helper(List<String> list) {
        if (list.size() == 1)
            return list.get(0);
        List<String> result = new ArrayList<>();
        int i = 0, j = list.size() - 1;
        while (i < j) {
            result.add("(" + list.get(i) + "," + list.get(j) + ")");
            i += 1;
            j -= 1;
        }
        return helper(result);
    }
}
