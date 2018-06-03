public class ZigzagIterator {
    
    private int[] index = new int[2];
    private int i = 0;
    private List<Integer> v1, v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (i == 0 && index[0] == v1.size())
            i = 1;
        if (i == 1 && index[1] == v2.size())
            i = 0;
        int result = 0;
        if (i == 0) {
            result = v1.get(index[0]);
            index[0] += 1;
        }
        if (i == 1) {
            result = v2.get(index[1]);
            index[1] += 1;
        }
        i ^= 1;
        return result;
    }

    public boolean hasNext() {
        return !(index[0] == v1.size() && index[1] == v2.size());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
