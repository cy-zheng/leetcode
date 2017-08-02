/*
    第一行和最后一行，每次加2n - 2
    中间的加两次：一次2n - 2i - 2，一次2i
*/
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) return s;
        char[] result = new char[s.length()];
        int k = 0;
        for (int i = 0; i < numRows; i++){
            int j = i;
            while (j < s.length()){
                if (i == 0 || i == numRows - 1){
                    result[k] = s.charAt(j);
                    j += 2 * numRows - 2;
                    k++;
                }
                else {
                    result[k] = s.charAt(j);
                    j += 2 * numRows - 2 * i - 2;
                    k++;
                    if (j < s.length()){
                        result[k] = s.charAt(j);
                        j += 2 * i;
                        k++;
                    }
                    else break;
                }
            }
        }
        return new String(result);
    }
}