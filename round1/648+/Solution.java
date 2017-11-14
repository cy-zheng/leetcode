import java.util.*;

class Solution {
    
    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> child;
        
        public TrieNode() {
            this.isWord = false;
            child = new HashMap<>();
        }
    }
    
    class TrieTree {
        TrieNode root;
        public TrieTree() {
            this.root = new TrieNode();
        }
        
        public void add(String s) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.child.containsKey(s.charAt(i)))
                    curr.child.put(s.charAt(i), new TrieNode());
                curr = curr.child.get(s.charAt(i));
            }
            curr.isWord = true;
        }
        
        public boolean find(String s) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.child.containsKey(s.charAt(i)))
                    return false;
                curr = curr.child.get(s.charAt(i));
            }
            return curr.isWord;
        }
        
        public boolean startsWith(String s) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.child.containsKey(s.charAt(i)))
                    return false;
                curr = curr.child.get(s.charAt(i));
            }
            return true;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        TrieTree tree = new TrieTree();
        for (String s : dict)
            tree.add(s);
        
        String[] words = sentence.split(" ");
        String[] target = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            boolean flag = false;
            for (int j = 1; j <= s.length(); j++) {
                String t = s.substring(0, j);
                if (!tree.startsWith(t)) {
                    break;
                }
                else if (tree.find(t)) {
                    target[i] = t;
                    flag = true;
                    break;
                }
            }
            
            if (!flag)
                target[i] = s;
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : target) {
            if (sb.length() != 0)
                sb.append(" ");
            sb.append(s);
        }
        return sb.toString();
    }
}