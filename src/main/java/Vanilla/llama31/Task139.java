package Vanilla.llama31;
// Java code
public class Task139 {
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        double[] radii = {1, 2, 3, 4, 5};
        for (double radius : radii) {
            System.out.println("The area of the circle with radius " + radius + " is: " + calculateCircleArea(radius));
        }
    }
}