/*
    注意h不能大于12，m不能大于60
*/

import java.util.*;

class Solution {
    public List<String> readBinaryWatch(int num) {
        boolean[] lights = new boolean[10];
        List<String> result = new ArrayList<>();
        dfs(result, lights, num, 0);
        return result;
    }
    
    private void dfs(List<String> result, boolean[] lights, int num, int startIndex) {
        if (num == 0) {
            String tmp = arrayToString(lights);
            if (tmp != null)
                result.add(tmp);
            return;
        }
        if (startIndex >= lights.length)
            return;
        for (int i = startIndex; i < lights.length; i++) {
            lights[i] = true;
            dfs(result, lights, num - 1, i + 1);
            lights[i] = false;
        }
    }
    
    private String arrayToString(boolean[] lights) {
        int h = 0, m = 0;
        for (int i = 0; i < 4; i++) {
            if (lights[i])
                h += (1 << i);
        }
        for (int i = 0; i < 6; i++) {
            if (lights[i + 4])
                m += (1 << i);
        }
        if (h >= 12 || m >= 60)
            return null;
        return h + ":" + String.format("%02d", m); 
    }
}