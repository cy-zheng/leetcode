/*
    We need to split A into B and C, the length of B can be [1, A.length / 2], we consider them one by one:
    B should have the same mean value as A, so sumB / lenOfB = sumA / lenOfA, which is equavalent to sumB = sumA * lenOfB / lenOfA. All elements here are integers, so sumB must be an integer, this gives our first criteria (sumA * lenOfB) % A.length == 0.
    Then further in function check(int[] A, int leftSum, int leftNum, int startIndex), we recursicely check if we can find lenOfB elements in A who sum up to sumB.
    
   (sumA * lenOfB) % A.length == 0 很重要。可以跳过很多多余计算，是由sumA / lenA = sumB / lenB = sumC / lenC 推导得出的
*/

import java.util.*;

class Solution {    
    public boolean check(int[] A, int leftSum, int leftNum, int startIndex) {       
        if (leftNum == 0) return leftSum == 0;
        if ((A[startIndex]) > leftSum / leftNum) return false;
        for (int i = startIndex; i < A.length - leftNum + 1; i ++) {
	    if (i > startIndex && A[i] == A[i - 1]) continue;
            if (check(A, leftSum - A[i], leftNum - 1, i + 1)) return true;
        }
        return false;       
    }
    
    public boolean splitArraySameAverage(int[] A) {
        if (A.length == 1) return false;
        int sumA = 0;
        for (int a: A) sumA += a;
        Arrays.sort(A);
        for (int lenOfB = 1; lenOfB <= A.length / 2; lenOfB ++) {
            if ((sumA * lenOfB) % A.length == 0) {
                if (check(A, (sumA * lenOfB) / A.length, lenOfB, 0)) return true;
            }
        }
        return false;
        
    }
}
