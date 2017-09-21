/*
    简洁优雅的解法：
    https://discuss.leetcode.com/topic/59293/java-easiest-solution-o-logn-with-explanation
    思路：
    1、每一次遍历，只计算最左边的元素，和步长
    2、最左边元素有两种情况需要被更新（加上当前步长）a.从左到右删元素 b.从右到左，有奇数个剩余元素
*/

class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}