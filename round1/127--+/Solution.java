/*
    注意层次遍历需要先缓存一个size
*/

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList)
            set.add(word);
        Set<String> used = new HashSet();
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        used.add(beginWord);
        queue.offer(beginWord);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord))
                    return level;
                for (int j = 0; j < curr.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        StringBuilder sb = new StringBuilder(curr);
                        String tmp = sb.replace(j, j + 1, Character.toString((char) ('a' + k))).toString();
                        if (set.contains(tmp) && !used.contains(tmp)) {
                            used.add(tmp);
                            queue.offer(tmp);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}