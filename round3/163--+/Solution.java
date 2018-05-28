class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long pre = (long) lower - 1;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] != pre + 1) {
                if (nums[i] == pre + 2) 
                    result.add(Integer.toString((int) pre + 1));
                else
                    result.add((pre + 1) + "->" + (nums[i] - 1));
            }
            pre = nums[i];
        }
        if (pre == upper)
            return result;
        if (pre + 1 == upper) {
            result.add(Integer.toString((int) pre + 1));
        }
        else {
            result.add((pre + 1) + "->" + upper);
        }
        return result;
    }
}
