package ZeroShot.claude;

public class Task139 {
    public static double calculateArea(double radius) {
        if(radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * radius * radius;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(calculateArea(5));   // 78.53981633974483
        System.out.println(calculateArea(2.5)); // 19.634954084936208
        System.out.println(calculateArea(0));   // 0.0
        System.out.println(calculateArea(10));  // 314.1592653589793
        System.out.println(calculateArea(7.5)); // 176.71458676442586
    }
}
