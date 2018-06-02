/*
    利用II的解法，求low到high全部的数字，排除不符合条件的
*/

class Solution {
    
    char[] single = new char[] {'0', '1', '8'};
    char[][] pair = new char[][] {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
    
    public int strobogrammaticInRange(String low, String high) {
        int result = 0;
        int lowLength = low.length(), highLength = high.length();
        if (highLength < lowLength || (highLength == lowLength && high.compareTo(low) < 0))
            return result;
        if (lowLength != highLength) {
            for (int i = lowLength + 1; i < highLength; i++) {
            result += findStrobogrammatic(i).size();
            }

            for (String r : findStrobogrammatic(lowLength)) {
                if (r.compareTo(low) >= 0)
                    result += 1;
            }
            for (String r : findStrobogrammatic(highLength)) {
                if (r.compareTo(high) <= 0)
                    result += 1;
            }
        }
        else {
            for (String r : findStrobogrammatic(lowLength)) {
                if (r.compareTo(low) >= 0 && r.compareTo(high) <= 0)
                    result += 1;
            }
        }
        
        return result;
    }
    
    private List<String> findStrobogrammatic(int n) {
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
