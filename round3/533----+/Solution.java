import java.util.*;

class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        int[] row = new int[picture.length];
        String[] list = new String[picture.length];
        int[] col = new int[picture[0].length];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
            list[i] = new String(picture[i]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && row[i] == N && col[j] == N) {
                    set.add(j);
                }
            }
        }

        int result = 0;
        outer: for (int j : set) {
            String pre = null;
            for (int i = 0; i < picture.length; i++) {
                if (picture[i][j] == 'B' && pre == null)
                    pre = list[i];
                else if (picture[i][j] == 'B' && !pre.equals(list[i]))
                    continue outer;
            }
            for (int i = 0; i < picture.length; i++) {
                if (picture[i][j] == 'B' && row[i] == N && col[j] == N)
                    result += 1;
            }
        }
        return result;
    }
}
