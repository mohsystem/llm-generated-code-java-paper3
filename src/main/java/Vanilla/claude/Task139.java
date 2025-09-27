package Vanilla.claude;

public class Task139 {
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(calculateArea(5));   // 78.53981633974483
        System.out.println(calculateArea(2.5)); // 19.634954084936208
        System.out.println(calculateArea(7));   // 153.93804002589985
        System.out.println(calculateArea(1));   // 3.141592653589793
        System.out.println(calculateArea(10));  // 314.1592653589793
    }
}
