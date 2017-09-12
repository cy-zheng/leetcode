/*
    使用Trie树实现后缀字典树，查询时，比如待查询的字符串是abcde
    那么，要查询后缀以edcba结尾的，后缀dcba的（取决于abcde的最后有几个是回文的，此处只有一个）
    如果存在空字符串，加上空字符串
    
    最后重新判断一下新的字符串的回文属性。
    此题优化可以从去重入手
*/

import java.util.*;

class Solution {
    
    class TrieNode {
        char word;
        List<Integer> index;
        boolean isWord;
        Map<Character, TrieNode> children;
        
        public TrieNode(char word, boolean isWord) {
            this.word = word;
            this.index = new ArrayList<>();
            this.isWord = isWord;
            this.children = new HashMap<>();
        } 
    }
    
    class TrieTree {
        TrieNode root;
        
        public TrieTree() {
            root = new TrieNode('0', false);  
        }
        
        public List<Integer> find(String str) {
            TrieNode p = root;
            for (int i = 0; i < str.length(); i++) {
                if (!p.children.containsKey(str.charAt(i)))
                    return new ArrayList<Integer>();
                p = p.children.get(str.charAt(i));
            }
            return p.isWord ? p.index : new ArrayList<Integer>();
        }
        
        public void add(String str, int index) {
            TrieNode p = root;
            for (int i = 0; i < str.length(); i++) {
                if (!p.children.containsKey(str.charAt(i)))
                    p.children.put(str.charAt(i), new TrieNode(str.charAt(i), false));
                p = p.children.get(str.charAt(i));
            }
            p.isWord = true;
            p.index.add(index);
        }
        
        public List<Integer> startsWith(String str) {
            List<Integer> result = new ArrayList<>();
            TrieNode p = root;
            for (int i = 0; i < str.length(); i++) {
                if (!p.children.containsKey(str.charAt(i)))
                    return result;;
                p = p.children.get(str.charAt(i));
            }
            if (p.isWord)
                result.addAll(p.index);
            
            for (char key : p.children.keySet()) {
                dfs(p.children.get(key), result);
            }
            
            return result;
        }
        
        private void dfs(TrieNode root, List<Integer> result) {
            if (root.isWord)
                result.addAll(root.index);
            for (char key : root.children.keySet()) {
                dfs(root.children.get(key), result);
            }
        }
    }
    
    private TrieTree tree;
    
    public List<List<Integer>> palindromePairs(String[] words) {
        tree = new TrieTree();
        for (int i = 0; i < words.length; i++)
            tree.add(new StringBuilder(words[i]).reverse().toString(), i);
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j : getPalindrome(tree, words[i])) {
                if (i == j || !isPalindrome(words[i] + words[j]))
                    continue;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                result.add(tmp);
            }
        }
        return result;
    }
    
    private Set<Integer> getPalindrome(TrieTree tree, String s1) {
        Set<Integer> result = new HashSet<>();
        result.addAll(tree.startsWith(s1));
        result.addAll(tree.find(""));
        if (s1.length() > 0) {
            for (int i = 0; i < s1.length(); i++) {
                if (isPalindrome(s1.substring(i, s1.length())))
                   result.addAll(tree.find(s1.substring(0, i))); 
            }
        }
            
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}