/*
    首先有两种情况会导致不匹配，左括号过多，或右括号过多。
    如()), (()
    需要两次调用remove，一次正序一次反序
*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        // par[0] + 1, par[1] - 1，这样设计方便反序遍历
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    // last_i是用来记录前面有序的部分，以后dfs可以省去一些计算
    // last_j就比较有意思了，考虑字符串()())())
    // 在第一次触发remove时，会生成两个局部解(())()) ()()())
    // 在第二次remove时，如果还是从头开始删除右括号，会有这样的两个解(()())，重复了，所以只能从往后的位置开始删除
    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                // 对于连续的)，只删除最靠左的
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
}
