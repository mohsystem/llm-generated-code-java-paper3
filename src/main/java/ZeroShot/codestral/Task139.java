package ZeroShot.codestral;
// Java
public class Task139 {
    public static double calculateCircleArea(double radius) {
        if(radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(calculateCircleArea(5));  // Expected: 78.53981633974483
        System.out.println(calculateCircleArea(0));  // Expected: 0.0
        System.out.println(calculateCircleArea(10)); // Expected: 314.1592653589793
        System.out.println(calculateCircleArea(2.5)); // Expected: 19.634954084936208
        try {
            System.out.println(calculateCircleArea(-1)); // Expected: IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}