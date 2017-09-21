class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) 
            return true;
        int index = 0;
        while (index < data.length) {
            if ((data[index] & 128) == 0) {
                index++;
            }
            else if ((data[index] & 128) != 0 && (data[index] & 64) != 0 && (data[index] & 32) == 0) {
                if (index + 1 >= data.length) return false;
                if (!((data[index + 1] & 128) != 0 && (data[index + 1] & 64) == 0)) return false;
                index += 2;
            }
            else if ((data[index] & 128) != 0 && (data[index] & 64) != 0 && (data[index] & 32) != 0 && (data[index] & 16) == 0) {
                if (index + 2 >= data.length) return false;
                for (int i = 1; i < 3; i++) {
                    if (!((data[index + i] & 128) != 0 && (data[index + i] & 64) == 0)) return false;
                }
                index += 3;
            }
            else if ((data[index] & 128) != 0 && (data[index] & 64) != 0 && (data[index] & 32) != 0 && (data[index] & 16) != 0 && (data[index] & 8) == 0) {
                if (index + 3 >= data.length) return false;
                for (int i = 1; i < 4; i++) {
                    if (!((data[index + i] & 128) != 0 && (data[index + i] & 64) == 0)) return false;
                }
                index += 4;
            }
            else 
                return false;
        }
        return true;
    }
}