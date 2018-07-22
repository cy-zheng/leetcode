/*
    Divide p,q by 2 until at least one odd.

    If p = odd, q = even: return 0
    If p = even, q = odd: return 2
    If p = odd, q = odd: return 1
    I summary it as return 1 - p % 2 + q % 2
*/

class Solution {
    public int mirrorReflection(int p, int q) {
        // p=4, q=2最终结果和p=2, q=1相同，化简
        while (p % 2 == 0 && q % 2 == 0) {p >>= 1; q >>= 1;}
        return 1 - p % 2 + q % 2;
    }
}
