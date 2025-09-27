package ZeroShot.gemini;
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
        double r = Math.sqrt(random.nextDouble()) * radius;
        double theta = random.nextDouble() * 2 * Math.PI;
        double x = x_center + r * Math.cos(theta);
        double y = y_center + r * Math.sin(theta);
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        Task197 solution = new Task197(1.0, 0.0, 0.0);
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));
        System.out.println(java.util.Arrays.toString(solution.randPoint()));


    }
}