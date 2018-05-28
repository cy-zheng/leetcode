/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/*
    NC题目
*/

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int curr = 4, index = 0;
        while (index < n && curr == 4) {
            curr = read4(tmp);
            for (int i = 0; i < curr; i++) {
                buf[index] = tmp[i];
                index += 1;
            }
        }
        return Math.min(index, n);
    }
}
