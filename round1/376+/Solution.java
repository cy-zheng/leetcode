/*
    如果一直下降，保存最小的，和新来的比较
    如果一直上升，保存最大的，和新来的比较
*/

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int min = nums[0];  // 下降用
        int max = nums[0];  // 上升用
        int length = 1;
        boolean isFalling = false;
        int startIndex = nums.length;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                isFalling = true;
                startIndex = i;
                break;
            }
            else if (nums[i] < nums[0]) {
                isFalling = false;
                startIndex = i;
                break;
            }
        }
        
        
        for (int i = startIndex; i < nums.length; i++) {
            if (isFalling && nums[i] > min) {
                isFalling = false;
                max = nums[i];
                length++;
            }
            else if (!isFalling && nums[i] < max) {
                isFalling = true;
                min = nums[i];
                length++;
            }
            else if (isFalling) 
                min = nums[i];
            else
                max = nums[i];
        }
        
        return length;
    }
}



/*
    Discuss的代码更简洁
    这种情况分两个数组保存更好
*/

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        if( nums.length == 0 ) return 0;
        
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        
        up[0] = 1;           // 如果当前位是上升得到的，最大长度
        down[0] = 1;         // 如果当前位是下降得到的，最大长度
        
        for(int i = 1 ; i < nums.length; i++){
            if( nums[i] > nums[i-1] ){
                up[i] = down[i-1]+1;
                down[i] = down[i-1];
            }else if( nums[i] < nums[i-1]){
                down[i] = up[i-1]+1;
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        
        return Math.max(down[nums.length-1],up[nums.length-1]);
    }
}