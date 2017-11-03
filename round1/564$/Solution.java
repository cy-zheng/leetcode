/*
    举个例子：str = 123456 
　　我们取左半部分substr = 123，题目要求“距离最短”显然，越左代表位数越高差值越大，所以我们考虑最右边的一个数（即原字符串中间的数）。substr1=124，substr2=122，至此我们可以得到3个候选string： 
　　candidate1 = 12321； 
　　candidate2 = 12421； 
　　candidate3 = 12221； 
　　还没完，如果例子为：88或者10 
　　显然相对应的我们应该返回101或者9,所以我们应该加入比原字符串多一位的100……001和比原字符串少一位的99……99作为候选。 
　　最后，我们选择candidate数组当中和原数值差值最小的返回就可以了。
*/

class Solution {
    long ans = 0, diff = Long.MAX_VALUE, n = 0;

    private void update(String val) {
        try {
            long tmp = Long.parseLong(val);
            if (tmp == n) return;
            if (Math.abs(tmp - n) < diff || (Math.abs(tmp - n) == diff && tmp < ans)) {
                ans = tmp;
                diff = Math.abs(tmp - n);
            }
        } catch (Exception e) { }
    }

    private void concat(long leftHalf) {
        String s = "" + leftHalf, rs = new StringBuilder(s).reverse().toString();
        update(s + rs); // abc -> abccba
        update(s + rs.substring(1)); // abc -> abcba
    }

    public String nearestPalindromic(String n) {
        this.n = Long.parseLong(n);
        diff = Long.MAX_VALUE;
        long leftHalf = Long.parseLong(n.substring(0, (n.length() + 1) / 2));
        concat(leftHalf - 1);
        concat((leftHalf - 1) * 10 + 9); // Handle 1, 1000, 100000, etc.
        concat(leftHalf);
        concat(leftHalf + 1);
        concat((leftHalf + 1) / 10); // Handle 9, 999, 99999, etc.
        return "" + ans;
    }
}