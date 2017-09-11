/*
    绝对不能等到最后判断一个字符串是否等于target，这样相当于多了n的复杂度
    思路是这样的：
    保留当前字符串的eval=curr，和这个字符串的上一个字符preNum
    对于加减法，修改curr加上或减去tmp，更新preNum（注意负数的preNum要带负号）
    
    乘法如何处理呢？这里我们需要用一个变量记录乘法当前累乘的值，直到累乘完了，遇到下一个加号或减号再将其算入计算结果中。这里有两种情况:

    乘号之前是加号或减号，例如2+3*4，我们在2那里算出来的结果，到3的时候会加上3，计算结果变为5。在到4的时候，因为4之前我们选择的是乘号，这里3就应该和4相乘，而不是和2相加，所以在计算结果时，要将5先减去刚才加的3得到2，然后再加上3乘以4，得到2+12=14，这样14就是到4为止时的计算结果。
    另外一种情况是乘号之前也是乘号，如果2+3*4*5，这里我们到4为止计算的结果是14了，然后我们到5的时候又是乘号，这时候我们要把刚才加的3*4给去掉，然后再加上3*4*5，也就是14-3*4+3*4*5=62。这样5的计算结果就是62。
*/

import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        for (int i = 0; i < num.length(); i++) {
            String tmpString = num.substring(0, i + 1);
            if (tmpString.length() > 1 && tmpString.charAt(0) == '0')
                continue;
            long tmpLong = Long.parseLong(tmpString);
            dfs(result, num, target, tmpString, i + 1, tmpLong, tmpLong);
        }
        
        return result;
    }
    
    private void dfs(List<String> result, String num, int target, String path, 
                     int index, long curr, long preNum) {
        if (index == num.length() && curr == target) {
            result.add(path);
            return;
        }
        
        for (int i = index; i < num.length(); i++) {
            String tmpString = num.substring(index, i + 1);
            if (tmpString.length() > 1 && tmpString.charAt(0) == '0')
                continue;
            long tmpLong = Long.parseLong(tmpString);
            dfs(result, num, target, path + "+" + tmpString, i + 1, curr + tmpLong, tmpLong);
            dfs(result, num, target, path + "-" + tmpString, i + 1, curr - tmpLong, -tmpLong);
            dfs(result, num, target, path + "*" + tmpString, i + 1, (curr - preNum) + preNum * tmpLong, preNum * tmpLong);
        }
    }
}