/*
    栈的简单应用
*/

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (a < 0) {
                if (stack.size() == 0 || stack.peek() < 0) {
                    stack.push(a);
                }
                else {
                    while (stack.size() > 0 && stack.peek() > 0 && stack.peek() < -a)
                        stack.pop();
                    if (stack.size() > 0 && stack.peek() == -a) 
                        stack.pop();
                    else {
                        if (stack.size() == 0 || stack.peek() < 0)
                            stack.push(a);
                    }
                }
            }
            else {
                stack.push(a);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) 
            result[i] = stack.pop();
        
        return result;
    }
}
