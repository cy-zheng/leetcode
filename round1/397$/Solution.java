/*
    -1可凑4的倍数的，-1
    +1可凑，+1
    3例外
*/


class Solution {
    public int integerReplacement(int n) {
        int result = 0;
        long num = n;
        while (num != 1) {
            result++;
            if (num % 2 == 0) 
                num /= 2;
            else if (num == 3 || num % 4 == 1) 
                num -= 1;
            else 
                num += 1;
        }
        return result;
    }
}