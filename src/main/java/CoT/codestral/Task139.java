package CoT.codestral;
public class Task139 {
    public static double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * Math.pow(radius, 2);
    }

    public static void main(String[] args) {
        System.out.println(calculateCircleArea(5));   // 78.53981633974483
        System.out.println(calculateCircleArea(10));  // 314.1592653589793
        System.out.println(calculateCircleArea(0));   // 0.0
        try {
            System.out.println(calculateCircleArea(-5));  // Throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(calculateCircleArea(12.3));  // 475.2040891132375
    }
}