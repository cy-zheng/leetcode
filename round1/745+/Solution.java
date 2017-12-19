import java.util.*;

class WordFilter {
    
    class TrieNode {
        int weight;
        Map<Character, TrieNode> child;
        public TrieNode() {
            weight = -1;
            child = new HashMap<>();
        }
    }
    
    class TrieTree {
        TrieNode root;
        
        public TrieTree() {
            root = new TrieNode();
        }
        
        public void add(String s, int weight) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.child.containsKey(s.charAt(i)))
                    curr.child.put(s.charAt(i), new TrieNode());
                curr = curr.child.get(s.charAt(i));
            }
            curr.weight = weight;
        }
        
        public Set<Integer> startsWith(String s) {
            Set<Integer> set = new HashSet<>();
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.child.containsKey(s.charAt(i)))
                    return set;
                curr = curr.child.get(s.charAt(i));
            }
            dfs(curr, set);
            return set;
        }
        
        private void dfs(TrieNode root, Set<Integer> set) {
            if (root.weight != -1)
                set.add(root.weight);
            for (Character key : root.child.keySet()) {
                dfs(root.child.get(key), set);
            }
        }
    }
    
    private TrieTree prefix, suffix;

    public WordFilter(String[] words) {
        prefix = new TrieTree();
        suffix = new TrieTree();
        for (int i = 0; i < words.length; i++) {
            prefix.add(words[i], i);
            suffix.add(new StringBuilder(words[i]).reverse().toString(), i);
        }
    }
    
    public int f(String prefix, String suffix) {
        int result = -1;
        Set<Integer> set1 = this.prefix.startsWith(prefix);
        Set<Integer> set2 = this.suffix.startsWith(new StringBuilder(suffix).reverse().toString());
        for (Integer key : set1) {
            if (set2.contains(key))
                result = Math.max(result, key);
        }
        return result;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
