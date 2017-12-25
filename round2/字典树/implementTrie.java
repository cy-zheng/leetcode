/*
    leetcode 208
    字典树的实现
*/

import java.util.*;

class Node {
    char val;
    boolean isWord;
    Map<Character, Node> children;
    Node(char val) {
        this.val = val;
        this.isWord = false;
        this.children = new HashMap<>();
    }
}

public class Trie {

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i)))
                cur.children.put(word.charAt(i), new Node(word.charAt(i)));
            cur = cur.children.get(word.charAt(i));
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i)))
                return false;
            cur = cur.children.get(word.charAt(i));
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.children.containsKey(prefix.charAt(i)))
                return false;
            cur = cur.children.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
