/*
    注意到我们需要小的W/Q比，而且所有人这个比值是一样的，但是假定我们选了k个人，最后给他们的开的W/Q又一定是k个人中最大的，不然有的人就满足不了最小的wage，所以W/Q是由大的数值主导。

    这样的话，就可以先对W/Q排序，这样W/Q值就是最后选的那个人，然后只要求Q总和最小的k个就好，于是sort+PriorityQueue
*/

import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker: workers) {
            if (pq.size() < K) {
                qsum += worker[1];
                pq.add(-worker[1]);
                if (pq.size() == K)
                    res = Math.min(res, qsum * worker[0]);
            }
            else {
                // 如果当前worker最大的，那么会接下来被移除
                pq.add(-worker[1]);    
                qsum += pq.poll() + worker[1];
                res = Math.min(res, qsum * worker[0]);
            }
        }
        return res;
    }
}
