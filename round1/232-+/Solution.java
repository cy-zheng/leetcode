import java.util.*;

class MyQueue {
    
    private boolean isReversed;
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        isReversed = false;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (isReversed) {
            while (stack2.size() > 0)
                stack1.push(stack2.pop());
        }
        isReversed = false;
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!isReversed) {
            while(stack1.size() > 0)
                stack2.push(stack1.pop());
        }
        isReversed = true;
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!isReversed) {
            while(stack1.size() > 0)
                stack2.push(stack1.pop());
        }
        isReversed = true;
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.size() == 0 && stack2.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */