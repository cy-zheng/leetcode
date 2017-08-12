/*
    注意最后一个char是.时，需要判断isWord
*/

import java.util.*;

class Node {
    char val;
    boolean isWord;
    Map<Character, Node> children;
    Node(char val) {
        this.val = val;
        this.isWord = false;
        children = new HashMap<>();
    }
}

public class WordDictionary {
    
    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node('0');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i)))
                cur.children.put(word.charAt(i), new Node(word.charAt(i)));
            cur = cur.children.get(word.charAt(i));
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word.length() == 0) return root.isWord;
        Queue<Node> queue = new LinkedList<>();
        int size;
        Node tmp;
        for (Character key : root.children.keySet()) {
            queue.offer(root.children.get(key));
        }
        for (int i = 0; i < word.length() - 1; i++) {
            size = queue.size();
            if (size == 0) return false;
            if (word.charAt(i) == '.'){
                for (int j = 0; j < size; j++) {
                    tmp = queue.poll();
                    for (Character key : tmp.children.keySet()) {
                        queue.offer(tmp.children.get(key));
                    }
                }
            }
            else{
                for (int j = 0; j < size; j++) {
                    tmp = queue.poll();
                    if (tmp.val == word.charAt(i)) {
                        for (Character key : tmp.children.keySet()) {
                            queue.offer(tmp.children.get(key));
                        } 
                    }
                }
            }
        }
        if (queue.size() == 0) return false;
        if (word.charAt(word.length() - 1) == '.') {
            while (queue.size() != 0) {
                tmp = queue.poll();
                if (tmp.isWord)
                    return true;
            }
        }
        else {
            while (queue.size() != 0) {
                tmp = queue.poll();
                if (tmp.val == word.charAt(word.length() - 1) && tmp.isWord)
                    return true;
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */