/*
    leetcode 155
    要求push，pop，peek，getMin都是O(1)，pq做不到
*/

import java.util.*;

class MinStack {
    
    private Stack<Integer> s1, s2;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.size() == 0 || s2.peek() >= x)
            s2.push(x);
    }

    public void pop() {
        if (s1.peek() == getMin())
            s2.pop();
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
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
