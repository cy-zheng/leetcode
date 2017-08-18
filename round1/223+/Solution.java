class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(Math.min(C, G), left);
        int top = Math.min(D, H);
        int bottom = Math.min(top, Math.max(B, F));
        return (C - A) * (D - B) + (G -E) * (H - F) - (right - left) * (top - bottom);
    }
}