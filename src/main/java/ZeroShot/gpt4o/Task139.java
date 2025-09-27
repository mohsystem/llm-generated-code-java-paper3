package ZeroShot.gpt4o;
public class Task139 {
    public static double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(calculateCircleArea(5));  // Test case 1
        System.out.println(calculateCircleArea(0));  // Test case 2
        System.out.println(calculateCircleArea(2.5)); // Test case 3
        System.out.println(calculateCircleArea(10)); // Test case 4
        System.out.println(calculateCircleArea(7.5)); // Test case 5
    }
}