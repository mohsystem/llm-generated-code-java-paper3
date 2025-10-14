package ZeroShot.openai;
import java.util.Random;

public class Task197 {
    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}

class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    private Random rand;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {
        double angle = 2 * Math.PI * rand.nextDouble();
        double distance = Math.sqrt(rand.nextDouble()) * radius;
        double x = x_center + distance * Math.cos(angle);
        double y = y_center + distance * Math.sin(angle);
        return new double[]{x, y};
    }
}