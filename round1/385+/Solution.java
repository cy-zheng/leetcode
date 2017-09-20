/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*;

class Solution {
    public NestedInteger deserialize(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == ']') {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                list.add(Character.toString(s.charAt(i)));
            }
            else if (s.charAt(i) == ',') {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() > 0)
            list.add(sb.toString());
        
        
        Stack<NestedInteger> stack = new Stack<>();
        for (String tmp : list) {
            if (tmp.equals("[")) {
                stack.push(new NestedInteger());
            }
            else if (tmp.equals("]")) {
                if (stack.size() > 1) {
                    NestedInteger finished = stack.pop();
                    stack.peek().add(finished);
                }
            }
            else {
                if (stack.size() > 0 && !stack.peek().isInteger()) {
                    stack.peek().add(new NestedInteger(Integer.parseInt(tmp)));
                }
                else {
                    stack.push(new NestedInteger(Integer.parseInt(tmp)));
                }
            }
        }
        
        return stack.pop();
    }
}