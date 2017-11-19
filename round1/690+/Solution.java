/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
import java.util.*;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) 
            map.put(e.id, e);
        
        return dfs(map, id);
    }
    
    private int dfs(Map<Integer, Employee> map, int id) {
        int result = map.get(id).importance;
        for (int child : map.get(id).subordinates)
            result += dfs(map, child);
        return result;
    }
}
