/*
    [0,0] -> "0"
    如何用Comparator自定义排序
*/

import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>(){
            public int compare(String s1, String s2) {
                long result1 = Long.parseLong(s1 + s2);
                long result2 = Long.parseLong(s2 + s1);
                if (result1 > result2)
                    return -1;
                else if (result1 < result2)
                    return 1;
                else
                    return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        int index = 0;
        while (index < sb.length() - 1 && sb.charAt(index) == '0')
            index++;
        return sb.substring(index);
    }
}