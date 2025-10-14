package CoT.openai;
public class Task139 {
    public static double calculateArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        double[] testRadii = {1.0, 2.5, 0.0, -3.0, 10.0};
        for (double radius : testRadii) {
            try {
                System.out.println("Area of circle with radius " + radius + " is: " + calculateArea(radius));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}