package ZeroShot.llama31;
public class Task139 {
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        double[] radii = {1, 2, 3, 4, 5};
        for (double radius : radii) {
            System.out.println("Area of circle with radius " + radius + ": " + calculateCircleArea(radius));
        }
    }
}