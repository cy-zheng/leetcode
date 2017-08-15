/*
    返回的result要去重
    dfs过程中变化的变量，应该在进入dfs之前set，退出之后reset，不要把这个工作放在函数里面
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

class TrieTree {
    private Node root;
    
    public TrieTree() {
        root = new Node('0');
    }
    
    public void add(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            if (!cur.children.containsKey(s.charAt(i))) {
                cur.children.put(s.charAt(i), new Node(s.charAt(i)));
            }
            cur = cur.children.get(s.charAt(i));
        }
        cur.isWord = true;
    }
    
    public boolean startsWith(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            if (!cur.children.containsKey(s.charAt(i))) {
                return false;
            }
            cur = cur.children.get(s.charAt(i));
        }
        return true;
    }
    
    public boolean find(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            if (!cur.children.containsKey(s.charAt(i))) {
                return false;
            }
            cur = cur.children.get(s.charAt(i));
        }
        return cur.isWord;
    }
    
}



public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        TrieTree tree = new TrieTree();
        for (String s : words)
            tree.add(s);
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                sb.append(board[i][j]);
                dfs(board, visited, tree, set, sb, i, j);
                sb.deleteCharAt(sb.length() - 1);
                visited[i][j] = false;
            }
        }
        for (String s : set)
            result.add(s);
        return result;
    }
    
    private void dfs(char[][] board, boolean[][] visited, TrieTree tree, Set<String> set, StringBuilder sb, int i, int j) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int x, y;
        if (tree.find(sb.toString()))
            set.add(sb.toString());
        else if (!tree.startsWith(sb.toString()))
            return;
        for (int k = 0; k < 4; k++) {
            x = i + dx[k];
            y = j + dy[k];
            if (check(visited, x, y)) {
                visited[x][y] = true;
                sb.append(board[x][y]);
                dfs(board, visited, tree, set, sb, x, y);
                sb.deleteCharAt(sb.length() - 1);
                visited[x][y] = false;
            }
        }
    }
    
    private boolean check(boolean[][] visited, int i, int j) {
        if (i < 0 || i >= visited.length)
            return false;
        if (j < 0 || j >= visited[0].length)
            return false;
        
        return !visited[i][j];
    }
    
}