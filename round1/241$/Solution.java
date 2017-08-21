/*
    分治思想 + 记忆化搜索，参考http://blog.csdn.net/happyaaaaaaaaaaa/article/details/51535462
*/

import java.util.*;

class Solution {
    
    private Map<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input))
            return map.get(input);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (input.charAt(i) == '+')
                            result.add(l + r);
                        else if (input.charAt(i) == '-')
                            result.add(l - r);
                        else
                            result.add(l * r);
                    }
                }
            }
        }
        
        if (result.size() == 0) result.add(Integer.parseInt(input));
        map.put(input, result);
        return result;
    }
}