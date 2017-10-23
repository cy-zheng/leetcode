class Solution {
    public int[] constructRectangle(int area) {
        int l = (int) Math.sqrt(area);
        int w = l;
        while (true) {
            if (l * w == area)
                return new int[] {l, w};
            l += 1;
            w = area / l;
        }
    }
}