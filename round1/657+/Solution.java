class Solution {
    public boolean judgeCircle(String moves) {
        int[] count = new int[4];
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U')
                count[0]++;
            if (moves.charAt(i) == 'D')
                count[1]++;
            if (moves.charAt(i) == 'L')
                count[2]++;
            if (moves.charAt(i) == 'R')
                count[3]++;
        }
        return count[0] == count[1] && count[2] == count[3];
    }
}
