import java.util.*;

class Solution {
    public List<Integer> splitIntoFibonacci(String s) {
        List<Integer> result = new LinkedList<>();
        if (s == null || s.length() == 0)
            return result;
        
        for (int i = 1; i < s.length(); i++) {
            if (i > 1 && s.charAt(0) == '0')
                break;
            long first = Long.parseLong(s.substring(0, i));
            if (first > Integer.MAX_VALUE)
                break;
            result.add((int) first);
            for (int j = i + 1; j < s.length(); j++) {
                if (j > i + 1 && s.charAt(i) == '0')
                    break;
                long second = Long.parseLong(s.substring(i, j));
                if (second > Integer.MAX_VALUE)
                    break;
                result.add((int) second);
                if (test(result, s, j))
                    return result;
                result.remove(result.size() - 1);
            }
            result.remove(result.size() - 1);
        }
        return result;
    }
    
    private boolean test(List<Integer> result, String s, int index) {
        if (index == s.length())
            return true;
        
        int first = result.get(result.size() - 2);
        int second = result.get(result.size() - 1);
        if (first + 0L + second > Integer.MAX_VALUE)
            return false;
        String third = "" + (first + second);
        if (s.indexOf(third, index) == -1)
            return false;
        result.add(first + second);
        boolean tmp = test(result, s, index + third.length());
        if (!tmp)
            result.remove(result.size() - 1);
        return tmp;
    }
}
