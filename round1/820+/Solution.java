import java.util.*;

class TrieNode {
    Map<Character, TrieNode> map;
    boolean isWord;
    public TrieNode() {
        this.map = new HashMap<>();
    }
}

public class Solution {
    private int result;
    
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        TrieNode root = new TrieNode();
        for (String s : words) {
            TrieNode curr = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (!curr.map.containsKey(s.charAt(i))) 
                    curr.map.put(s.charAt(i), new TrieNode());
                curr = curr.map.get(s.charAt(i));
            }
            curr.isWord = true;
        }
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TrieNode root, int length) {
        if (root == null)
            return;
        if (root.map.size() == 0 && root.isWord) {
            this.result += length + 1;
            return;
        }
        for (Character key : root.map.keySet()) {
            dfs(root.map.get(key), length + 1);
        }
    }
}
