/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

/*
    凸包算法，本题使用单调链算法
    参考：
    http://www.twinklingstar.cn/2016/3059/8-2-brief-convex-algorithm/
    http://www.cnblogs.com/weedboy/p/6896478.html
*/

import java.util.*;

class Solution {
    public List<Point> outerTrees(Point[] points) {
        Comparator<Point> comparator = new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.x != p2.x)
                    return p1.x - p2.x;
                return p1.y - p2.y;
            }
        };
        
        // 按照先x后y，增序排序
        Arrays.sort(points, comparator);
        // 因为要取栈顶两个元素，使用List代替Stack
        List<Point> result = new ArrayList<>();
        // 正向遍历
        for (int i = 0; i < points.length; i++) {
            // 如果新的点在栈顶两个点的右侧，旧的点出栈
            while (result.size() >= 2 && 
                   cross(points[i], result.get(result.size() - 1), result.get(result.size() - 2)) < 0)
                result.remove(result.size() - 1);
            result.add(points[i]);
        }
        
        // 反向遍历，出栈不能出正向遍历加进来的元素
        int size = result.size();
        for (int i = points.length - 2; i >= 0; i--) {
            while (result.size() > size && 
                  cross(points[i], result.get(result.size() - 1), result.get(result.size() - 2)) < 0)
                result.remove(result.size() - 1);
            result.add(points[i]);
        }
        // 排序去重
        Collections.sort(result, comparator);
        
        int i = result.size() - 1;
        while (i > 0) {
            Point p1 = result.get(i);
            Point p2 = result.get(i - 1);
            if (p1.x == p2.x && p1.y == p2.y)
                result.remove(i);
            i--;
        }
        return result;
    }
    
    // 判断O在向量AB的左侧还是右侧，result为正数，O在AB左侧，反之在右侧
    // http://blog.csdn.net/modiz/article/details/9928955
    private long cross(Point O, Point A, Point B){
        return (0L + A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
    }
}
