import java.util.*;

class MapSum {
    
    class TrieNode {
        int val;
        Map<Character, TrieNode> child;
        public TrieNode() {
            val = 0;
            child = new HashMap<>();
        }
    }
    
    class TrieTree {
        TrieNode root = new TrieNode();
        public void add(String s, int val) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.child.containsKey(s.charAt(i)))
                    curr.child.put(s.charAt(i), new TrieNode());
                curr = curr.child.get(s.charAt(i));
            }
            curr.val = val;
        }
        public int sum(String s) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.child.containsKey(s.charAt(i)))
                    return 0;
                curr = curr.child.get(s.charAt(i));
            }
            return getSum(curr);
        }
        
        public int getSum(TrieNode root) {
            int result = root.val;
            for (char key : root.child.keySet())
                result += getSum(root.child.get(key));
            return result;
        }
    }
    
    TrieTree tree;

    /** Initialize your data structure here. */
    public MapSum() {
        tree = new TrieTree();
    }
    
    public void insert(String key, int val) {
        tree.add(key, val);
    }
    
    public int sum(String prefix) {
        return tree.sum(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
