package ourMethodv2.gpt4o;
public class Task139 {
    public static double calculateArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(calculateArea(1.0)); // Test case 1
        System.out.println(calculateArea(2.0)); // Test case 2
        System.out.println(calculateArea(3.5)); // Test case 3
        System.out.println(calculateArea(0.0)); // Test case 4
        System.out.println(calculateArea(10.0)); // Test case 5
    }
}