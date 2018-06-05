class MovingAverage {
    
    int[] list;
    int size, capacity, sum, index;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        list = new int[size];
        capacity = size;
    }
    
    public double next(int val) {
        if (size < capacity) {
            list[index % capacity] = val;
            sum += val;
            size += 1;
        }
        else {
            sum -= list[index % capacity];
            list[index % capacity] = val;
            sum += val;
        }
        index += 1;
        return 1.0 * sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
