package ourMethod.claude;

public class Task139 {
    public static double calculateArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        
        // Using Math.PI for accurate pi value
        double area = Math.PI * radius * radius;
        
        // Check for overflow
        if (Double.isInfinite(area) || Double.isNaN(area)) {
            throw new ArithmeticException("Area calculation resulted in invalid value");
        }
        
        return area;
    }
    
    public static void main(String[] args) {
        // Test cases
        double[] testRadii = {0, 1, 2.5, 10, 100};
        
        for (double radius : testRadii) {
            try {
                double area = calculateArea(radius);
                System.out.printf("Area of circle with radius %.2f = %.2f%n", radius, area);
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
