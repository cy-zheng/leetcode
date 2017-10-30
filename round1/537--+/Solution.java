class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] aList = parseComplex(a);
        int[] bList = parseComplex(b);
        int[] r = new int[2];
        r[0] = aList[0] * bList[0] - aList[1] * bList[1];
        r[1] = aList[0] * bList[1] + aList[1] * bList[0];
        return r[0] + "+" + r[1] + "i";
    }
    
    private int[] parseComplex(String s) {
        String[] seg = s.substring(0, s.length() - 1).split("\\+");
        int[] r = new int[2];
        r[0] = Integer.parseInt(seg[0]);
        r[1] = Integer.parseInt(seg[1]);
        return r;
    }
}