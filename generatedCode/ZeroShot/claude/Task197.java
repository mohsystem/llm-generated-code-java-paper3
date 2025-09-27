package ZeroShot.claude;

import java.util.Random;

class Task197 {
    private double radius;
    private double xCenter;
    private double yCenter;
    private Random rand;

    public Task197(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.rand = new Random();
    }
    
    public double[] randPoint() {
        double angle = rand.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(rand.nextDouble()) * radius;
        double x = xCenter + r * Math.cos(angle);
        double y = yCenter + r * Math.sin(angle);
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        Task197 solution = new Task197(1.0, 0.0, 0.0);
        
        // Test cases
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.printf("Random point %d: [%.5f, %.5f]%n", i+1, point[0], point[1]);
            
            // Verify point is within circle
            double distance = Math.sqrt(Math.pow(point[0] - 0.0, 2) + Math.pow(point[1] - 0.0, 2));
            System.out.printf("Distance from center: %.5f (should be <= 1.0)%n", distance);
        }
    }
}
