import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        char[] charList = {'A', 'T', 'G', 'C'};
        for (String s : bank)
            bankSet.add(s);
        
        queue.add(start);
        visited.add(start);
        
        int level = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(end))
                    return level;
                StringBuilder sb = new StringBuilder(curr);
                for (int j = 0; j < sb.length(); j++) {
                    char origin = sb.charAt(j);
                    for (char c : charList) {
                        if (c == origin)
                            continue;
                        sb.setCharAt(j, c);
                        if (bankSet.contains(sb.toString()) && !visited.contains(sb.toString())) {
                            queue.add(sb.toString());
                            visited.add(sb.toString());
                        }
                    }
                    sb.setCharAt(j, origin);
                }
            }
            level++;
        }
        return -1;
    }
}