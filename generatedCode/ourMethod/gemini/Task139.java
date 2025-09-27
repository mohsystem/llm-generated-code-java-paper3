package ourMethod.gemini;
import java.util.Scanner;

public class Task139 {

    public static double calculateCircleArea(double radius) {
        if (radius < 0) {
            return -1; // Indicate invalid input
        }
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radius1 = 5.0;
        double area1 = calculateCircleArea(radius1);
        System.out.println("Area of circle with radius " + radius1 + ": " + area1);


        double radius2 = 0.0;
        double area2 = calculateCircleArea(radius2);
        System.out.println("Area of circle with radius " + radius2 + ": " + area2);

        double radius3 = 10.0;
        double area3 = calculateCircleArea(radius3);
        System.out.println("Area of circle with radius " + radius3 + ": " + area3);
        
        double radius4 = -2;
        double area4 = calculateCircleArea(radius4);
        System.out.println("Area of circle with radius " + radius4 + ": " + area4);
        
        double radius5 = 2.5;
        double area5 = calculateCircleArea(radius5);
        System.out.println("Area of circle with radius " + radius5 + ": " + area5);
    }
}