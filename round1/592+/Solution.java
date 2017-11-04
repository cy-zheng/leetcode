import java.util.*;

class Solution {
    
    class Fraction {
        boolean isPos;
        long n, d;
        public Fraction(boolean isPos, long n, long d) {
            this.isPos = isPos;
            this.n = n;
            this.d = d;
        }
        public void simplify() {
            long k = gcd(n, d);
            n /= k;
            d /= k;
        }
        private long gcd(long a, long b) {
            long k = 0;
            do {
                k = a % b;// 得到余数
                a = b;// 根据辗转相除法,把被除数赋给除数
                b = k;// 余数赋给被除数
            } while (k != 0);
            return a;// 返回被除数
        }
    }

    public String fractionAddition(String expression) {
        List<Fraction> list = new ArrayList<>();
        int i = 0, j = 0;
        boolean isPos = expression.charAt(0) != '-';
        while (i < expression.length() && j < expression.length()) {
            if (expression.charAt(j) == '+' || expression.charAt(j) == '-') {
                if (i != j) {
                    String[] seg = expression.substring(i, j).split("/");
                    list.add(new Fraction(isPos, Long.parseLong(seg[0]), Long.parseLong(seg[1])));
                }
                isPos = expression.charAt(j) != '-';
                i = j + 1;
                j = j + 1;
            }
            else
                j++;
        }
        if (i != j) {
            String[] seg = expression.substring(i, j).split("/");
            list.add(new Fraction(isPos, Long.parseLong(seg[0]), Long.parseLong(seg[1])));
        }

        Fraction result = new Fraction(true, 0, 1);
        for (Fraction f : list) {
            if (f.n == 0)
                continue;
            result.d *= f.d;
        }
        for (Fraction f : list) {
            if (f.n == 0)
                continue;
            f.n *= result.d / f.d;
        }
        for (Fraction f : list) {
            if (f.n == 0)
                continue;
            result.n = (result.isPos ? result.n : -result.n) + (f.isPos ? f.n : -f.n);
            if (result.n < 0) {
                result.isPos = false;
                result.n = -result.n;
            }
            else
                result.isPos = true;
        }
        result.simplify();
        return (result.isPos ? "" : "-") + result.n + "/" + result.d;
    }
}
