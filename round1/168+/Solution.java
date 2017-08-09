/*
    可以理解为10进制转26进制，但是26是从1开始的，所以需要-1操作
*/

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            sb.append((char)('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}