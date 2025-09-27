package Vanilla.codestral;
public class Task139 {
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(calculateCircleArea(1)); // π
        System.out.println(calculateCircleArea(2)); // 4π
        System.out.println(calculateCircleArea(3)); // 9π
        System.out.println(calculateCircleArea(4)); // 16π
        System.out.println(calculateCircleArea(5)); // 25π
    }
}