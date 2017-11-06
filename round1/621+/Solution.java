/*
    相当于一轮可以做n + 1个任务
    每次都选择剩余最多的任务做
*/

import java.util.*;

class Solution {
    
    class Task implements Comparable<Task>{
        char work;
        int count;
        public Task(char work, int count) {
            this.work = work;
            this.count = count;
        }
        
        public int compareTo(Task other) {
            return other.count - this.count;
        }
    }
    
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks)
            map.put(task, map.getOrDefault(task, 0) + 1);
        int result = 0;
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for (Character key : map.keySet())
            pq.add(new Task(key, map.get(key)));
        
        List<Task> tmp = new ArrayList<>();
        while (true) {
            for (int i = 0; i < n + 1; i++) {
                result++;
                if (pq.size() > 0) {
                    Task t = pq.poll();
                    t.count--;
                    if (t.count != 0)
                        tmp.add(t);
                }
                if (tmp.size() == 0 && pq.size() == 0)
                    return result;
            }
            for (Task t : tmp) {
                pq.add(t);
            }
            tmp = new ArrayList<>();
        }
    }
}