class StringIterator {
    
    String s;
    int index, num;
    char curr;

    public StringIterator(String compressedString) {
        s = compressedString;
    }
    
    public char next() {
        hasNext();
        if (num > 0) {
            num -= 1;
            return curr;
        }
        else {
            return ' ';
        }
    }
    
    public boolean hasNext() {
        if (num != 0)
            return true;
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                num *= 10;
                num += s.charAt(index) - '0';
            }
            else {
                if (num == 0) {
                    curr = s.charAt(index);
                } 
                else {
                    return true;
                }
            }
            index += 1;
        }
        return num != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
