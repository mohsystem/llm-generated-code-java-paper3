package ourMethod.claude;

import java.util.Random;

class Task197 {
    private final double radius;
    private final double xCenter;
    private final double yCenter;
    private final Random random;
    
    public Task197(double radius, double xCenter, double yCenter) {
        // Validate inputs
        if (radius <= 0 || radius > 1e8) {
            throw new IllegalArgumentException("Radius must be in range (0, 10^8]");
        }
        if (Math.abs(xCenter) > 1e7 || Math.abs(yCenter) > 1e7) {
            throw new IllegalArgumentException("Center coordinates must be in range [-10^7, 10^7]");
        }
        
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.random = new Random();
    }
    
    public double[] randPoint() {
        // Use rejection sampling for uniform distribution
        // Generate random angle and radius with proper distribution
        double angle = random.nextDouble() * 2 * Math.PI;
        // Use sqrt for uniform distribution in circular area
        double r = Math.sqrt(random.nextDouble()) * radius;
        
        double x = xCenter + r * Math.cos(angle);
        double y = yCenter + r * Math.sin(angle);
        
        return new double[]{x, y};
    }
    
    public static void main(String[] args) {
        // Test case 1
        Task197 solution1 = new Task197(1.0, 0.0, 0.0);
        double[] point1 = solution1.randPoint();
        System.out.println("Test 1: [" + point1[0] + ", " + point1[1] + "]");
        
        // Test case 2
        Task197 solution2 = new Task197(10.0, 5.0, -7.5);
        double[] point2 = solution2.randPoint();
        System.out.println("Test 2: [" + point2[0] + ", " + point2[1] + "]");
        
        // Test case 3
        Task197 solution3 = new Task197(2.0, 0.0, 0.0);
        double[] point3 = solution3.randPoint();
        System.out.println("Test 3: [" + point3[0] + ", " + point3[1] + "]");
        
        // Test case 4
        Task197 solution4 = new Task197(5.0, 10.0, 10.0);
        double[] point4 = solution4.randPoint();
        System.out.println("Test 4: [" + point4[0] + ", " + point4[1] + "]");
        
        // Test case 5
        Task197 solution5 = new Task197(0.5, -3.0, 4.0);
        double[] point5 = solution5.randPoint();
        System.out.println("Test 5: [" + point5[0] + ", " + point5[1] + "]");
    }
}
