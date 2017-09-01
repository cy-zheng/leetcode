import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> small, big;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        big.offer(num);
        rebalance();
    }
    
    public double findMedian() {
        if (small.size() == big.size())
            return (-small.peek() + big.peek()) / 2.0;
        return big.peek();
    }
    
    private void rebalance() {
        int tmp;
        while (small.size() > 0 && -small.peek() > big.peek()) {
            tmp = -small.poll();
            small.offer(-big.poll());
            big.offer(tmp);
        }
        if (big.size() - 1 > small.size())
            small.offer(-big.poll());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */