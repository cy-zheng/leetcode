import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int end = (int) Math.pow(2, n);
        for (int i = 0; i < end; i++) {
            int target = 0;
            for (int j = 0; j < n; j++) {
                int shift = (int) Math.pow(2, j + 2);
                boolean isOne = (i % shift) >= (shift / 4) && (i % shift) < (shift - shift / 4);
                if (isOne)
                    target |= (1 << j);
            }
            result.add(target);
        }
        return result;
    }
}
