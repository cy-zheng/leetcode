import java.util.*;

public class MinStack {
    
    private PriorityQueue<Integer> pq;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        pq = new PriorityQueue<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        pq.add(x);
        stack.push(x);
    }
    
    public void pop() {
        int result = stack.pop();
        pq.remove(result);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */