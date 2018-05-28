/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/*
    大概思路就是，搞一个全局变量把每次多读的存起来。
*/

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private String last = "";
    
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int index = 0, curr = 4;
        for (int i = 0; i < last.length(); i++) {
            buf[index] = last.charAt(i);
            index += 1;
        }
        last = "";
        while (index < n && curr == 4) {
            curr = read4(tmp);
            for (int i = 0; i < curr; i++) {
                buf[index] = tmp[i];
                index += 1;
            }
        }
        
        if (index > n) {
            for (int i = n; i < index; i++) {
                last += buf[i];
            }
            return n;
        } 
        else {
            return index;
        }
    }
}
