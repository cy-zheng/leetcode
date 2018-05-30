import java.util.*;

class Solution {
    
    char[] single = new char[] {'0', '1', '8'};
    char[][] pair = new char[][] {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
    
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, new char[n], 0, n);
        return result;
    }
    
    private void dfs(List<String> result, char[] list, int curr, int n) {
        if (n % 2 == 1 && curr > n / 2 || n % 2 == 0 && curr >= n / 2) {
            result.add(new String(list));
            return;
        } 
        if (n % 2 == 1 && curr == n / 2) {
           for (char num : single) {
               list[curr] = num;
               dfs(result, list, curr + 1, n);
           }
        }
        else {
            for (char[] num : pair) {
                if (curr == 0 && num[0] == '0')
                    continue;
                list[curr] = num[0];
                list[n - curr - 1] = num[1] ;
                dfs(result, list, curr + 1, n);
           }
        }
    }
}
