/*
    source和target长度可能不等，所以从右往左，避免index的修改
*/

class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(S);
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < indexes.length; ++i) { tm.put(indexes[i], i); }
        for (int key : tm.descendingKeySet()) {
            int i = tm.get(key);
            if (S.substring(indexes[i]).startsWith(sources[i])) {
                sb.replace(indexes[i], indexes[i] + sources[i].length(), targets[i]);
            }
        } 
        return sb.toString();
    }
}
