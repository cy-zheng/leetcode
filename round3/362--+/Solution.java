import java.util.*;

class Item {
    int timestamp, sum;
    Item(int timestamp, int sum) {
        this.timestamp = timestamp;
        this.sum = sum;
    }
}

public class HitCounter {
    
    int sum;
    List<Item> list;

    /** Initialize your data structure here. */
    public HitCounter() {
        sum = 0;
        list = new ArrayList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        sum += 1;
        list.add(new Item(timestamp, sum));
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (list.size() == 0)
            return 0;
        int before = 0, after = 0;
        int left = 0, right = list.size() - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid).timestamp > timestamp)
                right = mid;
            else
                left = mid;
        }
        if (list.get(right).timestamp <= timestamp)
            after = list.get(right).sum;
        else if (list.get(left).timestamp <= timestamp)
            after = list.get(left).sum;
        
        left = 0;
        right = list.size() - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid).timestamp > timestamp - 300)
                right = mid;
            else
                left = mid;
        }
        if (list.get(right).timestamp <= timestamp - 300)
            before = list.get(right).sum;
        else if (list.get(left).timestamp <= timestamp - 300)
            before = list.get(left).sum;
        return after - before;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
