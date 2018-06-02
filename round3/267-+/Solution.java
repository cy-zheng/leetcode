class Solution {
    public List<String> generatePalindromes(String s) {
        if (!canPermutePalindrome(s))
            return new ArrayList<>();
        
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] += 1;
        }
        List<String> result = new ArrayList<>();
        dfs(result, new StringBuilder(), count, s.length());
        return result;
    }
    
    private void dfs(List<String> result, StringBuilder sb, int[] count, int n) {
        if (n == 0) {
            String first = sb.toString();
            String last = new StringBuilder(first).reverse().toString();
            result.add(first + last);
            return;
        }
        if (n == 1) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    String last = new StringBuilder(sb.toString()).reverse().toString();
                    sb.append((char) i);
                    result.add(sb.toString() + last);
                    sb.deleteCharAt(sb.length() - 1);
                    return;
                }
            }
        }
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                count[i] -= 2;
                sb.append((char) i);
                dfs(result, sb, count, n - 2);
                sb.deleteCharAt(sb.length() - 1);
                count[i] += 2;
            }
        }
    }
    
    private boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] += 1;
        }
        
        boolean hasSingle = false;
        for (int i : count) {
            if (i % 2 == 1) {
                if (hasSingle)
                    return false;
                else
                    hasSingle = true;
            }
        }
        return true;
    }
}
