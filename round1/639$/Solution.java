/*
    DFS + 记忆化搜索不行，s太大栈溢出
    状态转移方程：
    f(i) = (ways(i) * f(i+1)) + (ways(i, i+1) * f(i+2))
    意为：将当前数字看成一个字母，乘以之后的组合数，加上将当前两个数字看成字符，乘以两个字符之后的组合数
*/

class Solution {
    public static int numDecodings(String s) {
        long[] res = new long[2];
        res[0] = ways(s.charAt(0));
        if(s.length() < 2) return (int)res[0];

        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        for(int j = 2; j < s.length(); j++) {
            long temp = res[1];
            res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1), s.charAt(j))) % 1000000007;
            res[0] = temp;
        }
        return  (int)res[1];
    }
    
    private static int ways(int ch) {
        if(ch == '*') return 9;
        if(ch == '0') return 0;
        return 1;
    }

    private static int ways(char ch1, char ch2) {
        String str = "" + ch1 + "" + ch2;
        if(ch1 != '*' && ch2 != '*') {
            if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
        } else if(ch1 == '*' && ch2 == '*') {
            return 15;
        } else if(ch1 == '*') {
            if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                return 2;
            else
                return 1;
        } else {
            if(Integer.parseInt(""+ch1) == 1 ) {
                return 9;
            } else if(Integer.parseInt(""+ch1) == 2 ) {
                return 6;
            } 
        }
        return 0;
    }

}
