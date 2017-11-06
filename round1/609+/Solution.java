import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] seg = path.split(" ");
            for (int i = 1; i < seg.length; i++) {
                String[] tmp = seg[i].split("\\(");
                String fileName = tmp[0];
                String content = tmp[1].substring(0, tmp[1].length() - 1);
                if (!map.containsKey(content))
                    map.put(content, new ArrayList<>());
                map.get(content).add(seg[0] + "/" + fileName);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1)
                result.add(map.get(key));
        }
        return result;
    }
}
