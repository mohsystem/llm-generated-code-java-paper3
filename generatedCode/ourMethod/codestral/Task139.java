package ourMethod.codestral;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task139 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the radius of the circle: ");
            double radius = scanner.nextDouble();
            if (radius < 0) {
                throw new IllegalArgumentException("Radius cannot be negative");
            }
            double area = calculateArea(radius);
            System.out.printf("The area of the circle is: %.2f%n", area);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
}