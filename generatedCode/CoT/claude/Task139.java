package CoT.claude;

public class Task139 {
    public static double calculateArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * radius * radius;
    }
    
    public static void main(String[] args) {
        // Test cases
        try {
            System.out.println("Area for radius 5: " + calculateArea(5));
            System.out.println("Area for radius 2.5: " + calculateArea(2.5));
            System.out.println("Area for radius 0: " + calculateArea(0));
            System.out.println("Area for radius 10: " + calculateArea(10));
            System.out.println("Area for radius 7.5: " + calculateArea(7.5));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
