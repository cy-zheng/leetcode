/*
    我们假设多边形的顶点是呈逆时针排列的，那么该多边形是凸多边形的充要条件是：对于多边形的任何一条边，其下一条边必须是不朝右拐的（可以向左拐，也可以不拐）。那么如何判断下一条边是不朝右拐呢？假设假设当前边形成的向量是v1，下一条边形成的向量是v2，那么v2不朝右拐的充要条件是v1 x v2 >= 0，也就是它们形成的有向平行四边形的面积大于等于0，符合右手法则。

    对于多边形顶点呈顺时针排列的情况，判断方式刚好相反。该算法的时间复杂度是O(n)，空间复杂度是O(1)。
    
    向量外积：https://zhuanlan.zhihu.com/p/34191849
*/

class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        for (long i = 0, n = points.size(), prev = 0, cur; i < n; ++i) {  
            cur = det2(points.get((int) i), points.get((int) ((i + 1) % n)), points.get((int) ((i + 2) % n)));  
            if (cur != 0) {  
                if (cur * prev < 0) {  
                    return false;  
                }  
                else {  
                    prev = cur;  
                }  
            }  
        }  
        return true;
    }
    
    private long det2(List<Integer> p0, List<Integer> p1, List<Integer> p2) {  
        // x1 * y2 - x2 * y1
        return (p1.get(0)-p0.get(0))*(p2.get(1)-p1.get(1)) - (p1.get(1)-p0.get(1))*(p2.get(0)-p1.get(0));  
    } 
}
