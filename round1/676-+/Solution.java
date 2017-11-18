/*
    注意hello -> hello = false
    hallo, hello -> hello = true
*/

import java.util.*;

class MagicDictionary {
    
    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> child;
        
        public TrieNode() {
            child = new HashMap<>();
        }
    }
    
    class TrieTree {
        TrieNode root = new TrieNode();
        public void add(String s) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.child.containsKey(s.charAt(i)))
                    curr.child.put(s.charAt(i), new TrieNode());
                curr = curr.child.get(s.charAt(i));
            }
            curr.isWord = true;
        }
        public boolean find(TrieNode curr, String s) {
            if (s.length() == 0)
                return false;
            boolean result = false;
            for (char key : curr.child.keySet()) {
                if (key == s.charAt(0)) {
                    result |= find(curr.child.get(key), s.substring(1));
                }
                else {
                    result |= findExactly(curr.child.get(key), s.substring(1));
                }
            }
            return result;
        }
        public boolean findExactly(TrieNode r, String s) {
            TrieNode curr = r;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.child.containsKey(s.charAt(i)))
                    return false;
                curr = curr.child.get(s.charAt(i));
            }
            return curr.isWord;
        }
    }
    
    private TrieTree tree;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        tree = new TrieTree();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) 
            tree.add(s);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return tree.find(tree.root, word);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
