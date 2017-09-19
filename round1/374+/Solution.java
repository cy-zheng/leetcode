/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) < 0)
                right = mid;
            else
                left = mid;
        }
        if (guess(left) == 0)
            return left;
        if (guess(right) == 0)
            return right;
        return -1;
    }
}