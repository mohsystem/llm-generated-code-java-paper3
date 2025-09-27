package Vanilla.gpt4o;
import java.util.Random;

class Task197 {
    private double radius;
    private double x_center;
    private double y_center;
    private Random rand;

    public Task197(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {
        double theta = 2 * Math.PI * rand.nextDouble();
        double r = Math.sqrt(rand.nextDouble()) * radius;
        double x = x_center + r * Math.cos(theta);
        double y = y_center + r * Math.sin(theta);
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        Task197 solution = new Task197(1.0, 0.0, 0.0);
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.printf("[%f, %f]%n", point[0], point[1]);
        }
    }
}