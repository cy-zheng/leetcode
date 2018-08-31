class Solution {
    public int uniqueLetterString(String S) {
        int res = 0;
        if (S == null || S.length() == 0)
            return res;    
        // char i上次出现的位置
        int[] showLastPosition = new int[128];
        // 上次i对于cur的贡献
        int[] contribution = new int[128];
        int cur = 0;
        for (int i = 0; i < S.length(); i++) {
            char x = S.charAt(i);
            // 因为当前增加一个字符，x由一个变成两个了，需要减去之前的contribution
            cur -= contribution[x]; 
            // 本次的贡献 = 到上一次出现之间的，以i结尾的所有子串Uniq + 1
            contribution[x] = (i - (showLastPosition[x] - 1));
            cur += contribution[x]; 
            showLastPosition[x] = i + 1;
            res += cur;
        }   
        return res;
    }
}
