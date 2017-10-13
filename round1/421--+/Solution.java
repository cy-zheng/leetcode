/*
    trie tree以O(1)查找有没有~n
    注意使用数组存children比map快太多
*/

import java.util.*;

class Solution {
    
    class TrieNode {
        TrieNode[] map;
        public TrieNode() {
            map = new TrieNode[2];
        }
    }
    
    class TrieTree {
        TrieNode root;
        
        public TrieTree() {
            root = new TrieNode();
        }
        
        public void add(int target) {
            TrieNode p = root;
            for (int i = 31; i >= 0; i--) {
                int flag = (target & (1 << i)) != 0 ? 1 : 0;
                if (p.map[flag] == null)
                    p.map[flag] = new TrieNode();
                p = p.map[flag];
            }
        }
        
        public int find(int n) {
            int target = ~n;
            int result = 0;
            TrieNode p = root;
            for (int i = 31; i >= 0; i--) {
                int flag = (target & (1 << i)) != 0 ? 1 : 0;
                if (p.map[flag] == null) {
                    p = p.map[flag ^ 1];
                }
                else {
                    result |= (1 << i);
                   p = p.map[flag];
                }
            }
            return result;   
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        TrieTree tree = new TrieTree();
        for (int i : nums) {
            tree.add(i);
        }
        int result = 0;
        for (int i : nums) {
            result = Math.max(result, tree.find(i));
        }
        return result;
    }
}