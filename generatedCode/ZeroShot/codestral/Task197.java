package ZeroShot.codestral;
import java.util.Random;

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
        double r = Math.sqrt(rand.nextDouble()) * radius;
        double theta = rand.nextDouble() * 2 * Math.PI;
        double x = x_center + r * Math.cos(theta);
        double y = y_center + r * Math.sin(theta);
        return new double[]{x, y};
    }
}

public class Task197 {
    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
        System.out.println(Arrays.toString(solution.randPoint()));
    }
}