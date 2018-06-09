/*
    注意要先从queue中拿出最后一个元素，然后在判断new head有没有撞到身体
*/

import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class SnakeGame {

    int width, height, foodIndex;
    int[][] food;
    Set<String> set;
    Deque<Point> queue;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.foodIndex = 0;
        this.food = food;
        this.set = new HashSet<>();
        this.set.add("0,0");
        this.queue = new LinkedList<>();
        this.queue.add(new Point(0, 0));
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] direct;
        if (direction.equals("U"))
            direct = new int[] {-1, 0};
        else if (direction.equals("L"))
            direct = new int[] {0, -1};
        else if (direction.equals("R"))
            direct = new int[] {0, 1};
        else
            direct = new int[] {1, 0};

        Point curr = queue.getFirst();
        int nx = curr.x + direct[0];
        int ny = curr.y + direct[1];

        if (nx < 0 || nx >= height)
            return -1;
        if (ny < 0 || ny >= width)
            return -1;
        if (foodIndex < food.length && food[foodIndex][0] == nx && food[foodIndex][1] == ny) {
            queue.addFirst(new Point(nx, ny));
            if (!set.add(nx + "," + ny))
                return -1;
            foodIndex += 1;
            return foodIndex;
        }
        else {
            Point tail = queue.pollLast();
            set.remove(tail.x + "," + tail.y);
            queue.addFirst(new Point(nx, ny));
            if (!set.add(nx + "," + ny))
                return -1;
            return foodIndex;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
