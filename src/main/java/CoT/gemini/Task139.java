package CoT.gemini;
import java.util.Scanner;

class Task139 {
    public static double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        double area = calculateCircleArea(radius);
        System.out.println("The area of the circle is: " + area);


        // Test cases
        System.out.println(calculateCircleArea(5)); // Expected: 78.53981633974483
        System.out.println(calculateCircleArea(10)); // Expected: 314.1592653589793
        System.out.println(calculateCircleArea(0)); // Expected: 0.0
        System.out.println(calculateCircleArea(1)); // Expected: 3.141592653589793
        try {
            System.out.println(calculateCircleArea(-1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected: Radius cannot be negative.
        }
    }
}