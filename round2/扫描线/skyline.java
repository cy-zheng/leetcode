/*
    leetcode 218
    扫描线算法
    point排序是关键：
    1、首先按照index排序
    2、index相同的时候，start排在end前面，保证不会出现一个长度为0的空档
    3、最后按照height排序，height排序规则为
        ①都是start，则height由大到小
        ②都是end，则height由小到大
        对于start来说，先将大的height入堆，那么后面的小的，都不能引起堆顶元素的变化，所以不需要进入result
        对于end来说，先将小的元素出堆，由于存在更大的元素，小的元素也不能引起堆顶元素的变化，所以不需要进入result
        
*/

import java.util.*;

class Point {
    int index;
    int height;
    boolean isStart;
    Point(int index, int height, boolean isStart) {
        this.index = index;
        this.height = height;
        this.isStart = isStart;
    }
}

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0)
            return result;
        
        Point[] points = new Point[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            points[2 * i] = new Point(buildings[i][0], buildings[i][2], true);
            points[2 * i + 1] = new Point(buildings[i][1], buildings[i][2], false);
        }
        
        Arrays.sort(points, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.index != p2.index)
                    return p1.index - p2.index;
                
                else if (p1.isStart != p2.isStart){
                    if (p1.isStart && !p2.isStart)
                        return -1;
                    else
                        return 1;
                }
                else {
                    if (p1.isStart)
                        return p2.height - p1.height;
                    else 
                        return p1.height - p2.height;
                }
                    
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(points.length, new Comparator<Integer>() {
            public int compare(Integer p1, Integer p2) {
                return p2 - p1;
            }
        });
        
        for (Point p : points) {
            if (p.isStart) {
                int cur = pq.size() == 0 ? -1 : pq.peek();
                pq.offer(p.height);
                if (cur < p.height) {
                    result.add(createPair(p.index, p.height));
                }
                
            }
            else {
                int cur = pq.peek();
                pq.remove(p.height);
                if (pq.size() == 0 || pq.peek() < cur) {
                    result.add(createPair(p.index, pq.size() == 0 ? 0 : pq.peek()));
                }
            }
        }
        
        return result;
    }
    
    private int[] createPair(int index, int height) {
        int[] result = new int[2];
        result[0] = index;
        result[1] = height;
        return result;
    }
}
