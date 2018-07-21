/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int val = rand5() + 1;
        if (rand2() == 0)
            return val + 5;
        return val;
    }
    
    public int rand5() {
        int val;
        do {
            val = rand7() - 1;
        }
        while (val >= 5);
        return val;
    }
    
    public int rand2() {
        int val;
        do {
            val = rand7() - 1;
        }
        while (val == 6);
        return val % 2;
    }
}
