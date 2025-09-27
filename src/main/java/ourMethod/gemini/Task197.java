package ourMethod.gemini;
import java.util.Random;

class Task197 {

    double radius;
    double x_center;
    double y_center;
    Random random;

    public Task197(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new Random();
    }

    public double[] randPoint() {
        double angle = random.nextDouble() * 2 * Math.PI;
        double r = radius * Math.sqrt(random.nextDouble());
        double x = x_center + r * Math.cos(angle);
        double y = y_center + r * Math.sin(angle);
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        Task197 solution1 = new Task197(1.0, 0.0, 0.0);
        System.out.println(java.util.Arrays.toString(solution1.randPoint()));
        System.out.println(java.util.Arrays.toString(solution1.randPoint()));
        System.out.println(java.util.Arrays.toString(solution1.randPoint()));


        Task197 solution2 = new Task197(0.000001, 0, 0);
        System.out.println(java.util.Arrays.toString(solution2.randPoint()));


        Task197 solution3 = new Task197(100, -50, 75.5);
        System.out.println(java.util.Arrays.toString(solution3.randPoint()));


        Task197 solution4 = new Task197(107.99, -107, 107);
        System.out.println(java.util.Arrays.toString(solution4.randPoint()));

        Task197 solution5 = new Task197(50, 0, 0);
        System.out.println(java.util.Arrays.toString(solution5.randPoint()));

    }
}