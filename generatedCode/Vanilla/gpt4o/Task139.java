package Vanilla.openai;
public class Task139 {
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(calculateArea(1.0)); // Test case 1
        System.out.println(calculateArea(2.5)); // Test case 2
        System.out.println(calculateArea(3.0)); // Test case 3
        System.out.println(calculateArea(4.4)); // Test case 4
        System.out.println(calculateArea(5.5)); // Test case 5
    }
}