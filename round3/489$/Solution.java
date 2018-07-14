/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
import java.util.*;

class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, visited, 0, 0, 0);
    }
    
    private void dfs(Robot robot, Set<String> visited, int x, int y, int direction) {
        if (visited.contains(x + " " + y))
            return;
        robot.clean();
        visited.add(x + " " + y);
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int nx = x, ny = y;
                if (direction == 0) {
                    nx += 1;
                }
                else if (direction == 90) {
                    ny += 1;
                }
                else if (direction == 180) {
                    nx -= 1;
                }
                else {
                    ny -= 1;
                }
                
                dfs(robot, visited, nx, ny, direction);
                
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            direction = (direction + 90) % 360;
        }
    }
}
