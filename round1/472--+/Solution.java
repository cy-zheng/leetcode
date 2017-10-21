/*
    DFS + Trie树
*/

import java.util.*;

class Solution {
    
    class TrieNode {
        char value;
        boolean isWord;
        Map<Character, TrieNode> map;
        public TrieNode(char value, boolean isWord) {
            this.value = value;
            this.isWord = isWord;
            this.map = new HashMap<>();
        }
    }
    
    class TrieTree {
        TrieNode root = new TrieNode('0', false);
        
        public void add(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                if (!p.map.containsKey(s.charAt(i)))
                    p.map.put(s.charAt(i), new TrieNode(s.charAt(i), false));
                p = p.map.get(s.charAt(i));
            }
            p.isWord = true;
        }
        
        public boolean find(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                if (!p.map.containsKey(s.charAt(i)))
                    return false;
                p = p.map.get(s.charAt(i));
            }
            return p.isWord;
        }
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        TrieTree tree = new TrieTree();
        for (String w : words) 
            tree.add(w);
        
        for (String w : words) {
            if (!w.equals("") && dfs(tree, w, 0))
                result.add(w);
        }
        
        return result;
    }
    
    private boolean dfs(TrieTree tree, String s, int start) {
        if (start >= s.length())
            return true;
        
        for (int end = s.length(); end >= start + 1; end--) {
            if (start == 0 && end == s.length())
                continue;
            if (tree.find(s.substring(start, end))) {
                if (dfs(tree, s, end))
                    return true;
            }
        }
        return false;
    }
}