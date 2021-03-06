/*
    hasNext负责将下一个元素读入到cache中
    peek和next负责返回cache的元素
    注意在peek和next之前先调用一下hasNext刷新缓存
*/


// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    private boolean hasCache;
    private int cache;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        hasCache = false;
        cache = 0;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasCache)
            hasNext();
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasCache)
            hasNext();
        hasCache = false;
        return cache;
    }

    @Override
    public boolean hasNext() {
        boolean result = iterator.hasNext();
        if (!result)
            return result || hasCache;
        else if (!hasCache){
            hasCache = true;
            cache = iterator.next();
        }
        return result;
    }
}