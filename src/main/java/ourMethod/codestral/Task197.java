package ourMethod.codestral;
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
        double angle = 2 * Math.PI * rand.nextDouble();
        double r = radius * Math.sqrt(rand.nextDouble());
        double x = r * Math.cos(angle) + x_center;
        double y = r * Math.sin(angle) + y_center;
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
    }
}