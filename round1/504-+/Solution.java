/*
    注意输入为0
*/

class Solution {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        
        boolean isPos = num >= 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        
        while (num != 0) {
            sb.insert(0, Integer.toString(num % 7));
            num /= 7;
        }
        
        if (!isPos)
            sb.insert(0, "-");
        
        return sb.toString();
    }
}