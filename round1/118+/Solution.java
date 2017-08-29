import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    tmp.add(1);
                else 
                    tmp.add(result.get(result.size() - 1).get(j - 1) + result.get(result.size() - 1).get(j));
            }
            result.add(tmp);
        }
        return result;
    }
}