package ourMethod.openai;
import java.util.Random;

class Task197 {
    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
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
        double angle = rand.nextDouble() * 2 * Math.PI;
        double length = Math.sqrt(rand.nextDouble()) * radius;
        double x = x_center + length * Math.cos(angle);
        double y = y_center + length * Math.sin(angle);
        return new double[]{x, y};
    }
}