class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        
        int left = 0, right = 1;
        int result = 0;
        while (left < A.length) {
            // 找到了山顶
            boolean hasPeak = false;
            // 上升
            while (right < A.length && A[right] > A[right - 1])
                right += 1;
            // 找到山顶 = 存在上升段 && 存在下降段
            if (right < A.length && right > left + 1 && A[right] < A[right - 1])
                hasPeak = true;
            // 下降
            while (hasPeak && right < A.length && A[right] < A[right - 1])
                right += 1;
            if (hasPeak) {
                result = Math.max(result, right - left);
                // 这里比较tricky，right - 1是最小的地方，left要从那里开始
                left = right - 1;
            }
            else {
                // left移到right，right后移1
                left = right;
                right = left + 1;
            }
        }
        return result;
    }
}
