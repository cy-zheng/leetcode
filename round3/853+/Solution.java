import java.util.*;

class Car implements Comparable<Car> {
    int pos, speed;
    Car(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
    public int compareTo(Car other) {
        return this.pos - other.pos;
    }
}

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        Collections.sort(cars);
        Stack<Car> stack = new Stack<>();
        for (Car car : cars) {
            while (stack.size() > 0 && canMerge(stack.peek(), car, target))
                stack.pop();
            stack.push(car);
        }
        return stack.size();
    }
    
    private boolean canMerge(Car lastCar, Car currCar, int target) {
        if (lastCar.speed <= currCar.speed)
            return false;
        return (target - lastCar.pos) * 1.0 / lastCar.speed <= 
            (target - currCar.pos) * 1.0 / currCar.speed;
    }
}
