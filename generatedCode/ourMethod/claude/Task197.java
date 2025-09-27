package ourMethod.claude;

import java.util.Random;

public class Task197 {
    private double radius;
    private double xCenter;
    private double yCenter;
    private Random random;

    public Task197(double radius, double x_center, double y_center) {
        if (radius <= 0 || radius > 1e8) {
            throw new IllegalArgumentException("Invalid radius");
        }
        if (Math.abs(x_center) > 1e7 || Math.abs(y_center) > 1e7) {
            throw new IllegalArgumentException("Invalid center coordinates");
        }
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
        this.random = new Random();
    }
    
    public double[] randPoint() {
        double len = Math.sqrt(random.nextDouble()) * radius;
        double angle = random.nextDouble() * 2 * Math.PI;
        
        double x = xCenter + len * Math.cos(angle);
        double y = yCenter + len * Math.sin(angle);
        
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        Task197 solution = new Task197(1.0, 0.0, 0.0);
        
        // Test cases
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.printf("Random point %d: [%.5f, %.5f]%n", i+1, point[0], point[1]);
            
            // Verify point is inside circle
            double distance = Math.sqrt(Math.pow(point[0] - 0.0, 2) + Math.pow(point[1] - 0.0, 2));
            System.out.printf("Distance from center: %.5f (should be <= 1.0)%n", distance);
        }
    }
}
