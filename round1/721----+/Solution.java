import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> getOwner = new HashMap<>();
        Map<String, String> unionFind = new HashMap<>();
        Map<String, List<String>> group = new HashMap<>();
        
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                getOwner.put(account.get(i), account.get(0));
                if (!unionFind.containsKey(account.get(i)))
                    unionFind.put(account.get(i), account.get(1));
                connect(unionFind, account.get(i), account.get(1));
            }
        }
        
        for (String key : unionFind.keySet()) {
            if (!group.containsKey(find(unionFind, key)))
                group.put(find(unionFind, key), new ArrayList<>());
            group.get(find(unionFind, key)).add(key);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (String key : group.keySet()) {
            Collections.sort(group.get(key));
            result.add(group.get(key));
            result.get(result.size() - 1).add(0, getOwner.get(key));
        } 
        return result;
    }
    
    private void connect(Map<String, String> unionFind, String s1, String s2) {
        String p1 = find(unionFind, s1);
        String p2 = find(unionFind, s2);
        if (!p1.equals(p2))
            unionFind.put(p1, p2);
    }
    
    private String find(Map<String, String> unionFind, String s) {
        String currString = s, currParent = unionFind.get(s);
        while (!currString.equals(currParent)) {
            currString = currParent;
            currParent = unionFind.get(currString);
        }
        
        unionFind.put(s, currParent);
        return currParent;
    }
}
