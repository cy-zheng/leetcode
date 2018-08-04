import java.util.*;

class Solution {
    public int kSimilarity(String A, String B) {
        char[] bList = B.toCharArray();
        Queue<String> queue = new LinkedList<>();
        queue.add(A);
        Set<String> set = new HashSet<>();
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(B))
                    return step;
                char[] currList = curr.toCharArray();
                for (int j = 0; j < currList.length; j++) {
                    if (currList[j] == bList[j])
                        continue;
                    for (int k = j + 1; k < currList.length; k++) {
                        if (currList[k] == bList[k] || currList[j] != bList[k])
                            continue;
                        swap(currList, j, k);
                        String s = new String(currList);
                        if (!set.contains(s)) {
                            queue.add(s);
                            set.add(s);
                        }
                        swap(currList, j, k);
                    }
                    /*
                        这一块儿可以这样理解：
                        1、找到currList第一个与bList不一样的字符
                        2、找到交换后至少能对一个的字符
                        3、交换后continue，假如source bacd target abdc，那么只交换ab就返回。
                        因为如果交换了cd，那么后续还需要交换ab；而交换了ab的后续也还需要交换cd，重复计算。
                    */
                    break;  
                }
            }
            step += 1;
        }
        return -1;
    }
    
    private void swap(char[] list, int i, int j) {
        char t = list[i];
        list[i] = list[j];
        list[j] = t;
    }
}
