/*
    如果不是用第一题的dp先检测一下存不存在break，会有一个case过不了。
*/

import java.util.*;

class TrieNode {
    public char value;
    public boolean isWord;
    public Map<Character, TrieNode> children;
    public TrieNode(char value, boolean isWord) {
        this.value = value;
        this.isWord = isWord;
        this.children = new HashMap<>();
    }
}

class TrieTree {
    private TrieNode root;
    public TrieTree() {
        this.root = new TrieNode('0', false);
    }
    
    public void add(String s) {
        TrieNode cur = this.root;
        for (int i = 0; i < s.length(); i++) {
            if (cur.children.get(s.charAt(i)) != null) {
                cur = cur.children.get(s.charAt(i));
            }
            else {
                cur.children.put(s.charAt(i), new TrieNode(s.charAt(i), false));
                cur = cur.children.get(s.charAt(i));
            }
            if (i == s.length() - 1) 
                cur.isWord = true;
        }
    }
    
    public TrieNode find(String s, int start, int end) {
        TrieNode cur = this.root;
        for (int i = start; i < end; i++) {
            if (cur.children.get(s.charAt(i)) != null) {
                cur = cur.children.get(s.charAt(i));
            }
            else {
                return null;
            }
            if (i == end - 1) 
                return cur;
        }
        return null;
    }
}

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        if (wordDict == null || wordDict.size() == 0) return result;
        if (!wordBreakHelper(s, wordDict)) return result;
        TrieTree tree = new TrieTree();
        for (String word : wordDict) {
            tree.add(word);
        }
        dfs(s, tree, 0, result, new ArrayList<String>());
        return result;
    }
    
    private void dfs(String s, TrieTree tree, int start, List<String> result, List<String> tmp) {
        if (start >= s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String part : tmp) {
                if (sb.length() > 0) sb.append(" ");
                sb.append(part);
            }
            result.add(sb.toString());
            return;
        }
        
        int end = start + 1;
        while (end <= s.length()) {
            TrieNode node = tree.find(s, start, end);
            if (node == null) return;
            else if (node.isWord == true) {
                tmp.add(s.substring(start, end));
                dfs(s, tree, end, result, tmp);
                tmp.remove(tmp.size() - 1);
            }
            end++;
        }
    }
    
    public boolean wordBreakHelper(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        if (wordDict == null || wordDict.size() == 0) return false;
        
        Set<String> dict = new HashSet<>();
        for(String s1 : wordDict) {
            dict.add(s1);
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i < s.length() + 1; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (dp[j] && dict.contains(s.substring(j, i)))
                    dp[i] = true;
                j--;
            }
        }
        
        return dp[s.length()];
    }
}