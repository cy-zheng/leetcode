import java.util.*;

class Solution {
    
    class Item {
        List<Integer> list;
        public Item(int a, int b, int c, int d) {
            list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            list.add(d);
            Collections.sort(list);
        }
        public int hashCode() {
            int code = 0;
            int mod = Integer.MAX_VALUE / 33;
            for (int i : list) {
                code *= 37;
                code += i ;
                code %= mod;
            }
            return code;
        }
        public boolean equals(Object o) {
            if (! (o instanceof Item))
                return false;
            Item other = (Item) o;
            for (int i = 0; i < 4; i++) {
                if (!this.list.get(i).equals(other.list.get(i)))   // 注意从Collection中拿出来的是Integer，要用equals比较是否相等
                    return false;
            }
            return true;
        }
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                if (!map.containsKey(nums[i] + nums[j]))
                    map.put(nums[i] + nums[j], new ArrayList<>());
                map.get(nums[i] + nums[j]).add(tmp);
            }
        }
        
        Set<Item> set = new HashSet<>();
        for (int key : map.keySet()) {
            for (List<Integer> l1 : map.get(key)) {
                for (List<Integer> l2 : map.getOrDefault(target - key, new ArrayList<>())) {
                    if (l2.indexOf(l1.get(0)) != -1 || l2.indexOf(l1.get(1)) != -1) {
                        continue;
                    }
                    set.add(new Item(nums[l1.get(0)], nums[l1.get(1)], nums[l2.get(0)], nums[l2.get(1)]));
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (Item item : set) {
            result.add(item.list);
        }
        return result;
    }
}
