/*
    写了半天dfs，原来是按照每个数字的特征，按照一定顺序确定到底有多少个字符
*/


import java.util.*;

class Solution {
    public String originalDigits(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<Map<Character, Integer>> numsMap = new ArrayList<>();
        Map<Character, Integer> sourceMap = new HashMap<>();
        for (String num : nums) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < num.length(); i++) {
                if (!map.containsKey(num.charAt(i)))
                    map.put(num.charAt(i), 0);
                map.put(num.charAt(i), map.get(num.charAt(i)) + 1);
            }
            numsMap.add(map);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!sourceMap.containsKey(s.charAt(i)))
                sourceMap.put(s.charAt(i), 0);
            sourceMap.put(s.charAt(i), sourceMap.get(s.charAt(i)) + 1);
        }   
        
        List<Integer> tmp = new ArrayList<>();
        while (sourceMap.containsKey('z')) {
            tmp.add(0);
            subtractMap(sourceMap, numsMap.get(0));
        }
        while (sourceMap.containsKey('w')) {
            tmp.add(2);
            subtractMap(sourceMap, numsMap.get(2));
        }
        while (sourceMap.containsKey('u')) {
            tmp.add(4);
            subtractMap(sourceMap, numsMap.get(4));
        }
        while (sourceMap.containsKey('x')) {
            tmp.add(6);
            subtractMap(sourceMap, numsMap.get(6));
        }
        while (sourceMap.containsKey('g')) {
            tmp.add(8);
            subtractMap(sourceMap, numsMap.get(8));
        }
        while (sourceMap.containsKey('s')) {
            tmp.add(7);
            subtractMap(sourceMap, numsMap.get(7));
        }
        while (sourceMap.containsKey('o')) {
            tmp.add(1);
            subtractMap(sourceMap, numsMap.get(1));
        }
        while (sourceMap.containsKey('v')) {
            tmp.add(5);
            subtractMap(sourceMap, numsMap.get(5));
        }
        while (sourceMap.containsKey('t')) {
            tmp.add(3);
            subtractMap(sourceMap, numsMap.get(3));
        }
        while (sourceMap.containsKey('n')) {
            tmp.add(9);
            subtractMap(sourceMap, numsMap.get(9));
        }
        StringBuilder result = new StringBuilder();
        Collections.sort(tmp);
        for (int i : tmp)
            result.append(Integer.toString(i));
        return result.toString();
    }
    
    private void subtractMap(Map<Character, Integer> source, Map<Character, Integer> target) {
        for (char key : target.keySet()) {
            if (source.get(key) > target.get(key))
                source.put(key, source.get(key) - target.get(key));
            else
                source.remove(key);
        }
    }
}