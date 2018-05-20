/*
    In the process traverse the array "answers", say the ith rabbit says there are k other rabbits have the same color with it, say color red, then there should be (k+1) rabbits in red totally. If previously we already found a color which has (k+1) rabbits are in, if it hasn't been fulfilled, red + 1, otherwise, say it's a new color, and the number starts at 1 in this new color
*/

class Solution {
    public int numRabbits(int[] answers) {
        // 说同一个数字的兔子数量
        int[] rabbits = new int[1001]; // colors and the number of rabbits in each color
        int ans = 0;
        for(int num: answers) {
            // 之前有兔子这样说过了
            if(rabbits[num + 1] > 0) {
                // 如果我们已经找齐了这个颜色的所有兔子，那么当前说的这个数字可以理解为一个新的颜色
                if(rabbits[num + 1] == num + 1) {
                    ans += rabbits[num + 1];
                    rabbits[num + 1] = 1;
                }
                // 增加一个计数
                else {
                    rabbits[num + 1]++;
                }
            }
            // 没有说过
            else {
                rabbits[num + 1] = 1;
            }
        }
        // 最后加起来
        for(int key = 1;key <= 1000;key++) {
            if(rabbits[key] > 0) ans += key;
        }
        return ans;
    }
}
