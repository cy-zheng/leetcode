import java.util.*;

class Solution {
    
    private double radius, x, y;
    private Random rand;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x = x_center;
        this.y = y_center;
        this.rand = new Random();
    }
    
    public double[] randPoint() {
        double r = Math.sqrt(rand.nextDouble()) * radius;
        double angle = rand.nextDouble() * 360;
        return new double[] {
            x + Math.cos(angle) * r,
            y + Math.sin(angle) * r
        };
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
