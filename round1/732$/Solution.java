/*
    扫描线算法
    e - 0.1，s + 0.1是为了结束排在开始之前
*/

class MyCalendarThree {
    private TreeMap<Double, Integer> times = new TreeMap<>();
    public int book(int s, int e) {
        times.put(s + 0.1, times.getOrDefault(s + 0.1, 0) + 1); // 1 new event will be starting at times[s]
        times.put(e - 0.1, times.getOrDefault(e - 0.1, 0) - 1); // 1 new event will be ending at times[e];
        int ongoing = 0, k = 0;
        for (int v : times.values())
            k = Math.max(k, ongoing += v);
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
