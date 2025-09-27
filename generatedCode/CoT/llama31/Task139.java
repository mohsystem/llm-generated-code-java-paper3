package CoT.llama31;
public class Task139 {
    static final double PI = Math.PI;

    public static double findArea(double r) {
        return PI * r * r;
    }

    public static void main(String[] args) {
        double[] testCases = {1, 2, 3, 4, 5};
        for (double r : testCases) {
            System.out.println("Area of Circle with radius " + r + " is: " + findArea(r));
        }
    }
}