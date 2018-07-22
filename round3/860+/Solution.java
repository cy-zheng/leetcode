class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];
        for (int num : bills) {
            int back = num - 5;
            if (back == 5) {
                if (money[0] == 0)
                    return false;
                money[0] -= 1;
            }
            else if (back == 15) {
                if (money[1] > 0 && money[0] > 0) {
                    money[1] -= 1;
                    money[0] -= 1;
                }
                else if (money[0] >= 3) {
                    money[0] -= 3;
                }
                else {
                    return false;
                }
            }
            if (num == 5)
                money[0] += 1;
            if (num == 10)
                money[1] += 1;
        }
        return true;
    }
}
