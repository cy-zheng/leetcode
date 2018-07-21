import java.util.*;

class Solution {
    public int calculate(String s) {
        // l1, o1表示优先级为1的操作数和操作符，o1为1表示+，o1为-1表示-
        int l1 = 0, o1 = 1;
        // l2, o2表示优先级为2的操作数和操作符，o1为1表示*，o1为2表示/
        int l2 = 1, o2 = 1;

        Deque<Integer> stack = new ArrayDeque<>(); // stack to simulate recursion

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // 当前字符是数字，读取全部数字，然后合并到l2
                int num = c - '0';

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }

                l2 = (o2 == 1 ? l2 * num : l2 / num);

            } else if (c == '(') {
                // 保存l1，o1，l2，o2，然后reset l1，o1，l2，o2
                // First preserve current calculation status
                stack.offerFirst(l1); stack.offerFirst(o1);
                stack.offerFirst(l2); stack.offerFirst(o2);

                // Then reset it for next calculation
                l1 = 0; o1 = 1;
                l2 = 1; o2 = 1;

            } else if (c == ')') {
                // 首先计算当前表达式的值（其实就是把l2合并到l1）
                // First preserve the result of current calculation
                int num = l1 + o1 * l2;
                // 然后恢复l1，o1，l2，o2
                // Then restore previous calculation status
                o2 = stack.poll(); l2 = stack.poll();
                o1 = stack.poll(); l1 = stack.poll();
                // 把当前表达式合并进l2
                // Previous calculation status is now in effect
                l2 = (o2 == 1 ? l2 * num : l2 / num);

            } else if (c == '*' || c == '/') {
                // 更新o2
                o2 = (c == '*' ? 1 : -1);

            } else if (c == '+' || c == '-') {
                // 首先把l2合并到l1
                l1 = l1 + o1 * l2;
                // 更新o1
                o1 = (c == '+' ? 1 : -1);
                // reset l2, o2
                l2 = 1; o2 = 1;
            }
        }
        // 最后把l2合并到l1
        return (l1 + o1 * l2);
    }
}
