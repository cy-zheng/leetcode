/*
    注意，题意是这一组字符串之间会按照给定顺序排序，而不是说这字符串之内包含特定顺序。
*/

import java.util.*;

class Word {
    int pre = 0;
    Set<Character> nexts = new HashSet<>();
}

public class Solution {
    public String alienOrder(String[] words) {
        Word[] counts = new Word[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (counts[word.charAt(i) - 'a'] == null)
                    counts[word.charAt(i) - 'a'] = new Word();
            }
        }
        // 纵向计算入度出度
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int m = 0, n = 0;
            while (m < curr.length() && n < next.length() && curr.charAt(m) == next.charAt(n)) {
                m += 1;
                n += 1;
            }
            if (m < curr.length() && n < next.length() && curr.charAt(m) != next.charAt(n)) {
                if (counts[curr.charAt(m) - 'a'].nexts.contains(next.charAt(n)))
                    continue;
                counts[curr.charAt(m) - 'a'].nexts.add(next.charAt(n));
                counts[next.charAt(n) - 'a'].pre += 1;
            }
        }
        // 拓扑排序
        StringBuilder sb = new StringBuilder();
        int charSum = 0;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == null)
                continue;
            charSum += 1;
            if (counts[i].pre == 0)
                queue.add((char) (i + 'a'));
        }
        
        while (queue.size() != 0) {
            char curr = queue.poll();
            sb.append(curr);
            for (char next : counts[curr - 'a'].nexts) {
                counts[next - 'a'].pre -= 1;
                if (counts[next - 'a'].pre == 0)
                    queue.add(next);
            }
        }
        return sb.length() == charSum ? sb.toString() : "";
    }
}
