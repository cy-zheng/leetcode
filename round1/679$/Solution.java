/*
    题意理解错，四个数字是可以交换位置的
    所以每次选出两个数字，做一次加减乘除，然后recursion就可以
*/

class Solution {
    public boolean judgePoint24(int[] nums) {
        return f(new double[] {nums[0], nums[1], nums[2], nums[3]});  // 转换为double
    }
    
    private boolean f(double[] a) {
        if (a.length == 1) {
            return Math.abs(a[0] - 24) < 1e-5;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                double[] b = new double[a.length - 1]; // 计算一次少了一个数字
                for (int k = 0, l = 0; k < a.length; k++) {
                    if (k != i && k != j) {
                        b[l++] = a[k];   // i 和 j是选中的两个数字，其他数字直接放到b里面
                    }
                }
                for (double k : compute(a[i], a[j])) {
                    b[a.length - 2] = k;   // 计算剩下的两个数字，然后递归
                    if (f(b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private double[] compute(double a, double b) {
        return new double[] {a + b, a - b, b - a, a * b, a / b, b / a};  // 可以交换数字的位置，所以a-b,b-a,a/b,b/a分开算
    }
}
