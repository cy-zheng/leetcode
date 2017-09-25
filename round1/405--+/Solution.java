class Solution {
    public String toHex(int num) {
        String result = "";
        for (int i = 7; i >= 0; i--) {
            int tmp = 0;
            for (int j = 3; j >= 0; j--) {
                if ((num & (1 << (4 * i + j))) != 0)
                    tmp |= (1 << j);
            }
            if (tmp < 10) {
                if (result.length() == 0 && tmp == 0)
                    continue;
                result = result + tmp;
            }
            else if (tmp == 10)
                result = result + "a";
            else if (tmp == 11)
                result = result + "b";
            else if (tmp == 12)
                result = result + "c";
            else if (tmp == 13)
                result = result + "d";
            else if (tmp == 14)
                result = result + "e";
            else
                result = result + "f";
        }
        return result.length() == 0 ? "0" : result;
    }
}