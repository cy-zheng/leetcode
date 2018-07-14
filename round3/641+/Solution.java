class MyCircularDeque {
    
    private int[] list;
    private int head, tail, size, capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        list = new int[k];
        capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == capacity)
            return false;
        head = (head + capacity - 1) % capacity;
        list[head] = value;
        size += 1;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == capacity)
            return false;
        list[tail] = value;
        tail = (tail + 1) % capacity;
        size += 1;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0)
            return false;
        head = (head + 1) % capacity;
        size -= 1;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0)
            return false;
        tail = (tail + capacity - 1) % capacity;
        size -= 1;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0)
            return -1;
        return list[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0)
            return -1;
        int index = (tail + capacity - 1) % capacity;
        return list[index];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
