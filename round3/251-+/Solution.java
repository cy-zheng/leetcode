public class Vector2D implements Iterator<Integer> {
    
    private List<List<Integer>> vec2d;
    private int i, j;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.i = 0;
        this.j = -1;
    }

    @Override
    public Integer next() {
        return vec2d.get(i).get(j);
    }

    @Override
    public boolean hasNext() {
        j += 1;
        while (i < vec2d.size() && j == vec2d.get(i).size()) {
            j = 0;
            i += 1;
        }
        if (i < vec2d.size() && j < vec2d.get(i).size())
            return true;
        else 
            return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
