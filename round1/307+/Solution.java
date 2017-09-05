/*
    树形数组经典题目，查询logN，更新logN
    参考：
    http://www.cnblogs.com/zichi/p/4806998.html
    http://www.cnblogs.com/zichi/p/4807072.html
*/

class NumArray {

    private int[] sum, nums;
    
    private int getNext(int x) {
        return x & (-x);
    }
    
    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length + 1];
        int p;
        for (int i = 1; i <= nums.length; i++) {
            p = i;
            while (p < sum.length) {
                sum[p] += nums[i - 1];
                p = p + getNext(p);
            }
        }
    }
    
    public void update(int i, int val) {
        int p = i + 1;
        int diff = val - nums[i];
        nums[i] = val;
        while (p < sum.length) {
            sum[p] += diff;
            p = p + getNext(p);
        }
    }
    
    private int sum(int i) {
        int n = i + 1;
        int result = 0;
        while (n > 0) {
            result += sum[n];
            n -= getNext(n);
        }
        return result;
    }
    
    public int sumRange(int i, int j) {
        if (i <= 0)
            return sum(j);
        else 
            return sum(j) - sum(i - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */