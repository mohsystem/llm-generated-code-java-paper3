package ZeroShot.llama31;
import java.util.Random;

public class Task197 {
    private double radius;
    private double xCenter;
    private double yCenter;
    private Random random;

    public Task197(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.random = new Random();
    }

    public double[] randPoint() {
        double length = Math.sqrt(random.nextDouble() * radius * radius);
        double angle = 2 * Math.PI * random.nextDouble();
        double x = xCenter + length * Math.cos(angle);
        double y = yCenter + length * Math.sin(angle);
        return new double[] {x, y};
    }

    public static void main(String[] args) {
        Task197 solution = new Task197(1.0, 0.0, 0.0);
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}