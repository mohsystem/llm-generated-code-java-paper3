package Vanilla.claude;

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
        double angle = rand.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(rand.nextDouble()) * radius;
        double x = x_center + r * Math.cos(angle);
        double y = y_center + r * Math.sin(angle);
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        // Test cases
        Task197 solution = new Task197(1.0, 0.0, 0.0);
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.printf("Random point %d: [%.5f, %.5f]%n", i+1, point[0], point[1]);
        }

        Task197 solution2 = new Task197(2.0, 1.0, 1.0);
        for (int i = 0; i < 5; i++) {
            double[] point = solution2.randPoint();
            System.out.printf("Random point %d (shifted): [%.5f, %.5f]%n", i+1, point[0], point[1]);
        }
    }
}
