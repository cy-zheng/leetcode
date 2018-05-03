/*
    手生，需要注意两点：
    1、(char) ((curr.charAt(j) - '0' + 1) % 10 + '0') 强制类型转换， 最后还要加上'0'
    2、StringBuilder没有实现equals和hashCode，是依靠比较地址，不能直接放入Set和Map
*/

import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }
        Queue<String> queue = new LinkedList<>();
        String begin = "0000";
        if (set.contains(begin))
            return -1;
        queue.add(begin);
        set.add(begin);
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                StringBuilder curr = new StringBuilder(queue.poll());
                if (curr.toString().equals(target))
                    return step;
                String tmp;
                for (int j = 0; j < 4; j++) {
                    curr.setCharAt(j, (char) ((curr.charAt(j) - '0' + 1) % 10 + '0'));
                    tmp = curr.toString();
                    if (!set.contains(tmp)) {
                        queue.add(tmp);
                        set.add(tmp);
                    }
                    curr.setCharAt(j, (char) ((curr.charAt(j) - '0' + 8) % 10 + '0'));
                    tmp = curr.toString();
                    if (!set.contains(tmp)) {
                        queue.add(tmp);
                        set.add(tmp);
                    }
                    curr.setCharAt(j, (char) ((curr.charAt(j) - '0' + 1) % 10 + '0'));
                }
            }
            step += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202");
    }
}
