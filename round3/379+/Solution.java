/*
    get, check, release都要求o(1)复杂度
*/

class PhoneDirectory {
    
    Set<Integer> used, valid;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        used = new HashSet<>();
        valid = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) {
            valid.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int r = -1;
        for (int i : valid) {
            r = i;
            break;
        }
        if (r != -1) {
            valid.remove(r);
            used.add(r);
        }
        return r;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return valid.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        used.remove(number);
        valid.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
