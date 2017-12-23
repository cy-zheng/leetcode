/*
    leetcode 179
    排序的比较方法：两个字串，谁拼在前面形成的int大一些，谁就大一些
    [0,0] -> "0"
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
