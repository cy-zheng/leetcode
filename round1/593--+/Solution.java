/*
    1、4个点有三种组合方式
    2、判断两个对角线是否相等
    3、判断两个对角线是否夹角90度
    4、判断两个对角线中点是否重合
*/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (test(p1, p2, p3, p4))
            return true;
        if (test(p1, p3, p2, p4))
            return true;
        if (test(p1, p4, p2, p3))
            return true;
        return false;
    }
    
    private boolean test(int[] p1, int[] p2, int[] p3, int[] p4) {
        double d1 = findDistance(p1, p2);
        double d2 = findDistance(p3, p4);
        if (d1 < 1e-6 || d2 < 1e-6)
            return false;
        if (Math.abs(d1 - d2) > 1e-6)
            return false;
        if (Math.abs(getDegree(p1, p2, p3, p4) + 1) > 1e-6)
            return false;
        double[] mid1 = getMidPoint(p1, p2);
        double[] mid2 = getMidPoint(p3, p4);
        if (Math.abs(mid1[0] - mid2[0]) > 1e-6)
            return false;
        if (Math.abs(mid1[1] - mid2[1]) > 1e-6)
            return false;
        return true;
    }
    
    private double findDistance(int[] p1, int[] p2) {
        return Math.pow(0.0 + p1[0] - p2[0], 2) + Math.pow(0.0 + p1[1] - p2[1], 2);
    }
    
    private double getDegree(int[] p1, int[] p2, int[] p3, int[] p4) {
        double k1 = (p1[1] - p2[1] + 0.0) / (p1[0] - p2[0]);
        double k2 = (p3[1] - p4[1] + 0.0) / (p3[0] - p4[0]);
        return k1 * k2;
    }
    
    private double[] getMidPoint(int[] p1, int[] p2) {
        return new double[] {(p1[0] + p2[0]) / 2.0, (p1[1] + p2[1]) / 2.0};
    }
}
