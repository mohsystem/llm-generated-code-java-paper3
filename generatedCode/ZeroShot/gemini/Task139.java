package ZeroShot.gemini;
import java.util.Scanner;

class Task139 {
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius1 = scanner.nextDouble();
        System.out.println(calculateArea(radius1));
        double radius2 = scanner.nextDouble();
        System.out.println(calculateArea(radius2));
        double radius3 = scanner.nextDouble();
        System.out.println(calculateArea(radius3));
        double radius4 = scanner.nextDouble();
        System.out.println(calculateArea(radius4));
        double radius5 = scanner.nextDouble();
        System.out.println(calculateArea(radius5));
        scanner.close();
    }
}