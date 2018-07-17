/*
    平移旋转不变的要点：
    1、找到这个图形的坐标集合
    2、旋转/对称   
        areas.get(0).add(new Point(p.x, p.y));
        areas.get(1).add(new Point(-p.x, p.y));
        areas.get(2).add(new Point(p.x, -p.y));
        areas.get(3).add(new Point(-p.x, -p.y));
        areas.get(4).add(new Point(p.y, p.x));
        areas.get(5).add(new Point(-p.y, p.x));
        areas.get(6).add(new Point(p.y, -p.x));
        areas.get(7).add(new Point(-p.y, -p.x));
    3、排序，其他点减去第一个点，第一个点置为0，0
*/

import java.util.*;

class Point implements Comparable<Point> {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point other) {
        if (this.x != other.x)
            return this.x - other.x;
        return this.y - other.y;
    }
}

public class Solution {

    private int result = 0;
    private int[] dx = new int[] {1, -1, 0, 0};
    private int[] dy = new int[] {0, 0, 1, -1};

    public int numDistinctIslands2(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<Point> points = bfs(grid, i, j);
                    for (Point p : points) {
                        grid[p.x][p.y] = 0;
                    }
                    List<List<Point>> areas = new ArrayList<>();
                    for (int k = 0; k < 8; k++) {
                        areas.add(new ArrayList<>());
                    }
                    for (Point p : points) {
                        areas.get(0).add(new Point(p.x, p.y));
                        areas.get(1).add(new Point(-p.x, p.y));
                        areas.get(2).add(new Point(p.x, -p.y));
                        areas.get(3).add(new Point(-p.x, -p.y));
                        areas.get(4).add(new Point(p.y, p.x));
                        areas.get(5).add(new Point(-p.y, p.x));
                        areas.get(6).add(new Point(p.y, -p.x));
                        areas.get(7).add(new Point(-p.y, -p.x));
                    }
                    List<String> strings = new ArrayList<>();
                    for (int k = 0; k < 8; k++) {
                        Collections.sort(areas.get(k));
                        for (int l = 1; l < areas.get(k).size(); ++l) {
                            areas.get(k).get(l).x -= areas.get(k).get(0).x;
                            areas.get(k).get(l).y -= areas.get(k).get(0).y;
                        }
                        areas.get(k).get(0).x = 0;
                        areas.get(k).get(0).y = 0;
                        StringBuilder sb = new StringBuilder();
                        for (Point p : areas.get(k)) {
                            sb.append("[" + p.x + "," + p.y + "]");
                        }
                        strings.add(sb.toString());
                    }
                    Collections.sort(strings);
                    set.add(strings.get(0));
                }
            }
        }
        return set.size();
    }

    private List<Point> bfs(int[][] grid, int x, int y) {
        List<Point> list = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        visited.add(x + "," + y);
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (queue.size() > 0) {
            Point curr = queue.poll();
            list.add(curr);
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (test(grid, visited, nx, ny)) {
                    visited.add(nx + "," + ny);
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return list;
    }

    private boolean test(int[][] grid, Set<String> visited, int nx, int ny) {
        if (nx < 0 || nx >= grid.length)
            return false;
        if (ny < 0 || ny >= grid[0].length)
            return false;
        if (grid[nx][ny] != 1)
            return false;
        return !visited.contains(nx + "," + ny);
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.numDistinctIslands2(new int[][] {
                {1,1,0,0,0},{1,0,0,0,0},{0,0,0,0,1},{0,0,0,1,1}
        });
    }
}
