/*
    单调栈简单应用
*/

import java.util.*;

class Solution {

    class Item {
        int temperature, index;
        public Item(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Item> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek().temperature <= temperatures[i])
                stack.pop();
            if (stack.size() > 0) {
                result[i] = stack.peek().index - i;
            }
            if (stack.size() == 0 || stack.peek().temperature >= temperatures[i]) {
                stack.push(new Item(temperatures[i], i));
            }
        }
        return result;
    }
}
