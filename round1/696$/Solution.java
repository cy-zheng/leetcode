/*
    时间复杂度O(N)，空间复杂度O(1)
    参考：http://www.cnblogs.com/grandyang/p/7716150.html
    那么我们来分析题目中的第一个例子00110011，符合要求的子字符串要求0和1同时出现，那么当第一个1出现的时候，前面由于前面有两个0，所以肯定能组成01，再遇到下一个1时，此时1有2个，0有2个，能组成0011，下一个遇到0时，此时0的个数重置为1，而1的个数有两个，所以一定有10，同理，下一个还为0，就会有1100存在，之后的也是这样分析。
    那么我们可以发现我们只要分别统计0和1的个数，而且如果当前遇到的是1，那么只要之前统计的0的个数大于当前1的个数，就一定有一个对应的子字符串，而一旦前一个数字和当前的数字不一样的时候，那么当前数字的计数要重置为1。所以我们遍历元数组，如果是第一个数字，那么对应的ones或zeros自增1。然后进行分情况讨论，如果当前数字是1，然后判断如果前面的数字也是1，则ones自增1，否则ones重置为1。如果此时zeros大于ones，res自增1。反之同理，如果当前数字是0，然后判断如果前面的数字也是0，则zeros自增1，否则zeros重置为1。如果此时ones大于zeros，res自增1。
*/

class Solution {
    public int countBinarySubstrings(String s) {
        int zeros = 0, ones = 0, res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i == 0) {
                if (s.charAt(i) == '1') 
                    ++ones;
                else
                    ++zeros;
            } else {
                if (s.charAt(i) == '1') {
                    ones = (s.charAt(i - 1) == '1') ? ones + 1 : 1;
                    if (zeros >= ones) ++res;
                } else if (s.charAt(i) == '0') {
                    zeros = (s.charAt(i - 1) == '0') ? zeros + 1 : 1;
                    if (ones >= zeros) ++res;
                }
            }
        }
        return res;
    }
}
