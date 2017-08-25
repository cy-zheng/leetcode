import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        for (String word : wordList)
            set.add(word);
        if (!set.contains(endWord))
            return result;
        Map<String, Integer> dist = new HashMap();
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        boolean isFind = false;
        dist.put(endWord, level);
        queue.offer(endWord);
        while (queue.size() != 0) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(beginWord)) {
                    isFind = true;
                    break;
                }
                for (int j = 0; j < curr.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        StringBuilder sb = new StringBuilder(curr);
                        String tmp = sb.replace(j, j + 1, Character.toString((char) ('a' + k))).toString();
                        if (set.contains(tmp) && !dist.containsKey(tmp)) {
                            dist.put(tmp, level);
                            queue.offer(tmp);
                        }
                    }
                }
            }
        }
        if (!isFind) return result;
        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        dfs(result, dist, beginWord, endWord, path);
        return result;
    }
    
    private void dfs(List<List<String>> result, Map<String, Integer> dist, String beginWord, String endWord, List<String> path) {
        if (beginWord.equals(endWord)) {
            List<String> copy = new ArrayList<>();
            copy.addAll(path);
            result.add(copy);
            return;
        }
        for (int j = 0; j < beginWord.length(); j++) {
            for (int k = 0; k < 25; k++) {
                StringBuilder sb = new StringBuilder(beginWord);
                String tmp = sb.replace(j, j + 1, Character.toString((char) ('a' + k))).toString();
                if (dist.containsKey(tmp) && dist.get(tmp) < dist.get(beginWord)) {
                    path.add(tmp);
                    dfs(result, dist, tmp, endWord, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}