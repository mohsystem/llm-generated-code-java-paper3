package ourMethod.llama31;
public class Task139 {
    public static void main(String[] args) {
        // Test cases
        double[] radii = {1.0, 2.0, 3.0, 4.0, 5.0};
        for (double radius : radii) {
            System.out.println("Area of circle with radius " + radius + ": " + calculateCircleArea(radius));
        }
    }

    public static double calculateCircleArea(double radius) {
        // Validate input to prevent negative or zero radius
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be a positive number");
        }
        
        // Calculate area using the formula: π * r^2
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }
}