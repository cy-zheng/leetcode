/*
    注意溢出，转为long
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder result = new StringBuilder();
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) 
            result.append("-");
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        if (n < d) result.append("0");
        boolean isDecimal = false;
        Map<Long, Integer> map = new HashMap<>();
        String cur, tail;
        while (n != 0) {
            if (n < d && !isDecimal) {
                result.append(".");
                isDecimal = true;
            }  
            
            if (isDecimal && map.containsKey(n)) {
                tail = result.substring(map.get(n));
                return result.substring(0, map.get(n)) + "(" + tail + ")";
            }
            
            if (n < d) n *= 10;
            cur = Long.toString(n / d);
            result.append(cur);
            if (isDecimal){
                map.put(n / 10, result.length() - 1);
            }
            n %= d;
        }
        return result.toString();
    }
}