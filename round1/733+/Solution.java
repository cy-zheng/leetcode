import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});
        int source = image[sr][sc];
        if (source == newColor)
            return image;
        image[sr][sc] = newColor;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (queue.size() > 0) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < image.length && ny < image[0].length 
                    && image[nx][ny] == source) {
                    queue.add(new int[] {nx, ny});
                    image[nx][ny] = newColor;
                }
            }
        }
        return image;
    }
}
