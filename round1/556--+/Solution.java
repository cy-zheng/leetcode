import java.util.*;

class Solution {
    public int nextGreaterElement(int n) {
        String source = Integer.toString(n);
        String target = null;
        char[] sourceList = source.toCharArray();
        int left = sourceList.length - 1, right;
        /*
            思路如下：
            1、双指针，代表高位的左指针从右往左，优先选择交换低位
            2、右指针从右往左，代表低位
            3、交换以后，对后面的数字重新升序排序
        */
        while (left >= 0) {
            right = sourceList.length - 1;
            while (right >= left) {
                if (sourceList[left] < sourceList[right])
                    break;
                right--;
            }
            if (left >= 0 && right >= 0 && left < right) {
                char tmp = sourceList[left];
                sourceList[left] = sourceList[right];
                sourceList[right] = tmp;
                target = new String(sourceList);
                target = target.substring(0, left + 1) + sortString(target.substring(left + 1));
                break;
            }
            else 
                left--;
        }
        
        if (target == null)
            return -1;
        if (Long.parseLong(target) > Integer.MAX_VALUE)
            return -1;
        return Integer.parseInt(target);
    }
    
    // 把String按照升序排序
    private String sortString(String s) {
        char[] list = s.toCharArray();
        // Java API不支持使用Comparator对基本类型进行排序
        Arrays.sort(list);
        int i = 0, j = list.length - 1;
        return new String(list);
    } 
}