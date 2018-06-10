import java.util.*;

class TrieNode {
    Map<Character, TrieNode> map = new HashMap<>();
    boolean isWord = false;
}

class TrieTree {
    TrieNode root = new TrieNode();
    
    public void add(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!curr.map.containsKey(c))
                curr.map.put(c, new TrieNode());
            curr = curr.map.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean find(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!curr.map.containsKey(c))
                return false;
            curr = curr.map.get(c);
        }
        return curr.isWord;
    }
    
    public List<String> startsWith(String s) {
        List<String> result = new ArrayList<>();
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!curr.map.containsKey(c))
                return result;
            curr = curr.map.get(c);
        }
        if (curr.isWord)
            result.add(s);
        
        StringBuilder sb = new StringBuilder(s);
        for (char key : curr.map.keySet()) {
            sb.append(key);
            dfs(result, sb, curr.map.get(key));
            sb.deleteCharAt(sb.length() - 1);
        }
        return result;
    }
    
    private void dfs(List<String> result, StringBuilder sb, TrieNode curr) {
        if (curr.isWord)
            result.add(sb.toString());
        for (char key : curr.map.keySet()) {
            sb.append(key);
            dfs(result, sb, curr.map.get(key));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        TrieTree tree = new TrieTree();
        for (String word : words) {
            tree.add(word);
        }
        List<List<String>> result = new ArrayList<>();
        if (words.length == 0)
            return result;
        dfs(tree, result, new ArrayList<>(), words[0].length());
        return result;
    }
    
    private void dfs(TrieTree tree, List<List<String>> result, List<String> path, int n) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (String s : path) {
            prefix.append(s.charAt(path.size()));
        }
        List<String> nexts = tree.startsWith(prefix.toString());
        for (String next : nexts) {
            path.add(next);
            dfs(tree, result, path, n);
            path.remove(path.size() - 1);
        }
    }
}
