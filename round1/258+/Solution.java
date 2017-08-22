/*
    我们先来观察1到20的所有的树根：

    1    1
    2    2
    3    3
    4    4
    5    5
    6    6
    7    7
    8    8    
    9    9    
    10    1
    11    2
    12    3    
    13    4
    14    5
    15    6
    16    7
    17    8
    18    9
    19    1
    20    2

    根据上面的列举，我们可以得出规律，每9个一循环，所有大于9的数的树根都是对9取余，那么对于等于9的数对9取余就是0了，为了得到其本身，而且同样也要对大于9的数适用，我们就用(n-1)%9+1这个表达式来包括所有的情况，所以解法如下：
    
    return (num - 1) % 9 + 1;
*/


class Solution {
    public int addDigits(int num) {
        String tmp = Integer.toString(num);
        num = 0;
        while (tmp.length() != 1) {
            for (int i = 0; i < tmp.length(); i++) {
                num += tmp.charAt(i) - '0';
            }
            tmp = Integer.toString(num);
            num = 0;
        }
        return Integer.parseInt(tmp);
    }
}