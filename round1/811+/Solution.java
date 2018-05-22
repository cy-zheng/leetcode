/*
    需要注意java String.split(regex)，"."需要转义
*/

import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] list = cpdomain.split(" ");
            int count = Integer.parseInt(list[0]);
            String[] domain = list[1].split("\\.");
            for (int i = 0; i < domain.length; i++) {
                String subdomain = join(domain, i, domain.length - 1);
                map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key) + " " + key);
        }
        return result;
    }
    
    private String join(String[] list, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (sb.length() != 0)
                sb.append(".");
            sb.append(list[i]);
        }
        return sb.toString();
    }
}
