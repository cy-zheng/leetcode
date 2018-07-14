class MyCircularQueue {
    
    private int[] list;
    private int head, tail, size, capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        list = new int[k];
        capacity = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == capacity)
            return false;
        list[tail] = value;
        tail = (tail + 1) % capacity;
        size += 1;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0)
            return false;
        head = (head + 1) % capacity;
        size -= 1;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0)
            return -1;
        return list[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0)
            return -1;
        int index = (tail + capacity - 1) % capacity;
        return list[index];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
