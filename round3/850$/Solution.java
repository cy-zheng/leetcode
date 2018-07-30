/*
    花了一点时间才理解这个道题的解法，写英文太累，就索性给个中文解释好了。首先我们来回想以下skyline那道题，用到的是扫描线的方法。我们对于进入的building 边界用正数，当building出去的时候用负数。这里的正负数，也就是Point 里的val 这个值，其实就是更好的表示一个building进入和出去。
    同理，这里也是如此，我们用1 和 -1 来表示矩形需要处理面积与否。
    对于同一个x，我们想下y轴怎么处理的。举例子最好，对于例子 rec1 [0, 0, 2, 2] , rec2 [0, 3, 2, 4]
    按这个方法
    data.add(new Point(r[0], r[1], 1));
    data.add(new Point(r[0], r[3], -1));
    data.add(new Point(r[2], r[1], -1));
    data.add(new Point(r[2], r[3], 1));
    那么我们会有point [0, 0, 1], [0, 2, -1], [0, 3, 1], [0, 4, -1] ...
    我们现在就关注x = 0 的情况，这里为什么要用 1 和 -1， 就是用来标识 矩形开始边界和矩形结束边界的
    去看下calcY函数，用来计算preY，这里的preY对于x = 0 就是3。3怎么来的 ？ 换个问法你就懂了，问：对于x = 0，求这上面覆盖的y的区间和是多少 ？ 注意这几个点 point [0, 0, 1], [0, 2, -1], [0, 3, 1], [0, 4, -1]。 看每个点中间的column 也就是y的值。y 从0 开始被覆盖，到 2 的时候因为val 是 -1，注意calY函数里的count 算上这个点之前是 > 0 的，所以 0 - 2 被覆盖了，接下来是 3 - 4 被覆盖了。总共被覆盖的区域是多少？
    （2 - 0） + （4 - 3） = 3. 所以preY = 3。我们此时x = 0这个地方都处理完了，那么遇到第一个x = 1的点的时候，我们需要用下面这个公式计算当前需要加入最后结果的面积，也就是 preY * （cur.x - pre.x），这里preY = 3, cur.x = 2, pre.x = 0. 那么我们 x = 0的地方就处理完了，同理对于 其他平行于 y 轴的 “x = ？” 的线。但是对于最靠右的矩形的右边界，你不要忘记处理，也就是为什么我们有** if (i == data.size() - 1 || data.get(i + 1).x > p.x)** 这个判定条件。如果有人问为什么这里定义treemap。因为treemap里面的key是排序的，那么为什么不每个平行于x轴的地方都建一个treemap呢 ？ 因为一个矩形如果扫描到了它的右边界，自然而然我们就会将它的点从我们treemap中抹去。
    接下来就是为什么要这么思考了。拿到题目的时候，如果你觉得要从overlap矩形角度思考的话，你会发现这种情况corner case 太多了，来回处理重合区域的矩形表示会容易出bug。那么对于矩形的问题，有什么其他处理方法吗？题目给的矩形无非是两个点（左下和右上）表示，那么如果按某个轴排序的话，你用一条扫描线，自行脑补，就会发现这里的面积可以降成一维来做。一维扫描线问题，想想之前做过什么类似的，比如meeting rooms，但meeting rooms 重合的地方不要去重，比如一个meeting 在 [1, 2], 另一个也在 [1, 2]，这里算两个room，我们这里因为要消去重合的地方，所以可以简化为这个问题。某天有n个meetings，都会在楼L里的meeting room/s里举行，问你楼L总共有多少时间被占用？
    Special thanks to wangzi6147 的解法 ！
*/

import java.util.*;

class Solution {
    class Point { // define a class to called Point to better solve such problem
        int x, y, val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int rectangleArea(int[][] rectangles) {
        int M = 1000000007;
        List<Point> data = new ArrayList<>();
        for (int[] r : rectangles) {
            data.add(new Point(r[0], r[1], 1));
            data.add(new Point(r[0], r[3], -1));
            data.add(new Point(r[2], r[1], -1));
            data.add(new Point(r[2], r[3], 1));
        }
        Collections.sort(data, (a, b) -> {
            if (a.x == b.x) {
                return b.y - a.y;
            }
            return a.x - b.x;
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int preX = -1;
        int preY = -1;
        int result = 0;
        for (int i = 0; i < data.size(); i++) {
            Point p = data.get(i);
            map.put(p.y, map.getOrDefault(p.y, 0) + p.val);
            if (i == data.size() - 1 || data.get(i + 1).x > p.x) {
                if (preX > -1) {
                    result += ((long)preY * (p.x - preX)) % M;
                    result %= M;
                }
                preY = calcY(map);
                preX = p.x;
            }
        }
        return result;
    }
    private int calcY(TreeMap<Integer, Integer> map) {
        int result = 0, pre = -1, count = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (pre >= 0 && count > 0) {
                result += e.getKey() - pre;
            }
            count += e.getValue();
            pre = e.getKey();
        }
        return result;
    }
}
