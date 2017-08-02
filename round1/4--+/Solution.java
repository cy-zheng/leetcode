/*
    主要在于从两个数组中找到第k大
    每次取k/2比较，如果一个数组元素不足k/2那么直接取最后一个元素比较
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1){
            return findKlargeth(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
        }        
        else {
            return (findKlargeth(nums1, nums2, (nums1.length + nums2.length) / 2) +
                findKlargeth(nums1, nums2, (nums1.length + nums2.length) / 2 + 1)) * 1.0 / 2;
        }
    }
    
    private int findKlargeth(int[] nums1, int[] nums2, int k) {
        int i = 0;
        int j = 0;
        while (k != 1 && i < nums1.length && j < nums2.length) {
            if (i + k / 2 - 1 < nums1.length && j + k / 2 - 1 < nums2.length){
                if (nums1[i + k / 2 - 1] < nums2[j + k / 2 - 1])
                    i += k / 2;
                else
                    j += k / 2;
                k -= k / 2;
            }
            else if (i + k / 2 - 1 >= nums1.length){
                if (nums1[nums1.length - 1] < nums2[j + k / 2 - 1]){
                    k -= nums1.length - i;
                    i = nums1.length;
                }
                else {
                    j += k / 2;
                    k -= k / 2;
                } 
            }
            else {
                if (nums1[i + k / 2 - 1] < nums2[nums2.length - 1]){
                    i += k / 2;
                    k -= k / 2;
                }
                else {
                    k -= nums2.length - j;
                    j = nums2.length;
                } 
            }
        }

        if (i < nums1.length && j < nums2.length)
            return Math.min(nums1[i], nums2[j]);
        else if (i < nums1.length)
            return nums1[i + k - 1];
        else
            return nums2[j + k - 1];
    }
}