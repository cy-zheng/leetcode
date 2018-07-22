class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                // 重要，隔开和之前的
                stack.push(-1);
            } else {
                // 合并同一层的，遇到-1停止
                int cur = 0;
                while (stack.peek() != -1) {
                    cur += stack.pop();
                }
                stack.pop();
                // 如果是空的，1入栈，否则2 * cur入栈
                stack.push(cur == 0 ? 1 : cur * 2);
            }
        }
        // 最后一次合并
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
