/*
    用一个32位int存储各个字符的出现情况，用两个int的and操作，求两个字符串是否存在字符交集
*/


class Solution {
    public int maxProduct(String[] words) {
        int[] characters = new int[words.length];
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                characters[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((characters[i] & characters[j]) == 0)
                    result = Math.max(result, words[i].length() * words[j].length());
            }
        }
        return result;
    }
}