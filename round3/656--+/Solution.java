/*
    经典的单序列dp，step设置比较玄学。
*/

import java.util.*;

class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] last = new int[A.length];
        int[] cost = new int[A.length];
        int[] step = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            last[i] = -1;
            cost[i] = Integer.MAX_VALUE;
            step[i] = Integer.MAX_VALUE;
        }
        last[0] = 0;
        cost[0] = 0;
        step[0] = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == -1 || last[i] == -1)
                continue;
            for (int j = i + 1; j <= i + B && j < A.length; j++) {
                if (A[j] == -1)
                    continue;
                if (cost[i] + A[j] < cost[j]) {
                    cost[j] = cost[i] + A[j];
                    last[j] = i;
                    step[j] = step[i] + 1;
                }
                // 两种走法cost一样
                else if (cost[i] + A[j] == cost[j]) {
                    // 倾向于选择长的
                    if (step[i] + 1 > step[j]) {
                        step[j] = step[i] + 1;
                        last[j] = i;
                    }
                    // 长度一样倾向于选择字符序小的
                    else if (step[i] + 1 == step[j] && i < last[j]) {
                        last[j] = i;
                    }
                }
            }
        }

        int curr = A.length - 1;
        List<Integer> result = new ArrayList<>();
        while (curr != 0) {
            result.add(curr + 1);
            curr = last[curr];
            if (curr == -1)
                return new ArrayList<>();
        }
        result.add(1);
        Collections.reverse(result);
        return result;
    }
}
