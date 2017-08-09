/*
    2的个数一定比5少，只算5就可以
    
    注意越界
    
    example:
    
    By given number 4617.

    5^1 : 4617 ÷ 5 = 923.4, so we get 923 factors of 5                    

    5^2 : 4617 ÷ 25 = 184.68, so we get 184 additional factors of 5

    5^3 : 4617 ÷ 125 = 36.936, so we get 36 additional factors of 5

    5^4 : 4617 ÷ 625 = 7.3872, so we get 7 additional factors of 5

    5^5 : 4617 ÷ 3125 = 1.47744, so we get 1 more factor of 5

    5^6 : 4617 ÷ 15625 = 0.295488, which is less than 1, so stop here.

    Then 4617! has 923 + 184 + 36 + 7 + 1 = 1151 trailing zeroes.
    
*/

public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        for (long i = 5; i <= n; i *= 5) {         //相当于第一趟找5的倍数，每个+1；第二趟找25的倍数，每个+1
            result += (int)(n / i);
        }
        return result;
    }
}