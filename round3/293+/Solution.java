import java.util.*;

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        char[] list = s.toCharArray();
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == '+' && list[i + 1] == '+') {
                list[i] = '-';
                list[i + 1] = '-';
                result.add(new String(list));
                list[i] = '+';
                list[i + 1] = '+';
            }
        }
        return result;
    }
}
