import java.util.*;

class Char implements Comparable<Char> {
    char val;
    int count;
    Char(char val, int count) {
        this.val = val;
        this.count = count;
    }
    public int compareTo(Char other) {
        return other.count - this.count;
    }
}

public class Solution {
    public String rearrangeString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        Queue<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        PriorityQueue<Char> pq = new PriorityQueue<>();
        for (char key : map.keySet()) {
            pq.add(new Char(key, map.get(key)));
        }
        while (pq.size() > 0) {
            if (queue.size() > 0 && queue.size() >= k) {
                char old = queue.poll();
                set.remove(old);
            }
            Char curr = getNext(pq, set);
            if (curr == null)
                return "";
            sb.append(curr.val);
            queue.add(curr.val);
            set.add(curr.val);
        }
        return sb.toString();
    }

    private Char getNext(PriorityQueue<Char> pq, Set<Character> set) {
        List<Char> list = new ArrayList<>();
        while (pq.size() > 0) {
            Char curr = pq.poll();
            if (set.contains(curr.val)) {
                list.add(curr);
            }
            else {
                curr.count -= 1;
                if (curr.count > 0)
                    list.add(curr);
                for (Char c : list) {
                    pq.add(c);
                }
                return curr;
            }
        }
        return null;
    }
}
