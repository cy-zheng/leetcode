import java.util.*;

class Solution {
    
    class State {
        boolean state;
        int i1, i2;
        public State(boolean state, int i1, int i2) {
            this.state = state;
            this.i1 = i1;
            this.i2 = i2;
        }
    }
    
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null)
            return new String[0];
        if (list1.length == 0 || list2.length == 0)
            return new String[0];
        
        
        Map<String, State> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            if (!map.containsKey(list1[i])) {
                map.put(list1[i], new State(false, i, Integer.MAX_VALUE));
            }
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i]) && !map.get(list2[i]).state) {
                map.get(list2[i]).state = true;
                map.get(list2[i]).i2 = i;
            }
        }
        
        int minIndex = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        
        for (String key : map.keySet()) {
            if (map.get(key).state && map.get(key).i1 + map.get(key).i2 <= minIndex) {
                if (map.get(key).i1 + map.get(key).i2 < minIndex) {
                    minIndex = map.get(key).i1 + map.get(key).i2;
                    result = new ArrayList<>();
                }
                result.add(key);
            }
        }
        
        String[] r = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}
