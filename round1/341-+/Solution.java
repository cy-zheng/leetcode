/*
    注意处理NestedInteger为空列表的情况
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private int curr;
    private List<NestedInteger> nestedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.curr = 0;
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        return nestedList.get(curr++).getInteger();
    }

    @Override
    public boolean hasNext() {
        if (curr == nestedList.size())
            return false;
        if (!nestedList.get(curr).isInteger()) {
            List<NestedInteger> tmp = nestedList.get(curr).getList();
            nestedList.remove(curr);
            for (int i = tmp.size() - 1; i >= 0; i--) {
                nestedList.add(curr, tmp.get(i));
            }
            return hasNext();
        }
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */