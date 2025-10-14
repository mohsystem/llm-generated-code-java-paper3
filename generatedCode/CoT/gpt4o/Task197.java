package CoT.openai;
import java.util.Random;

class Task197 {
    private double radius;
    private double x_center;
    private double y_center;
    private Random rand;

    public Task197(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {
        double x, y;
        do {
            x = (2 * rand.nextDouble() - 1) * radius;
            y = (2 * rand.nextDouble() - 1) * radius;
        } while (x * x + y * y > radius * radius);
        return new double[]{x_center + x, y_center + y};
    }

    public static void main(String[] args) {
        Task197 solution = new Task197(1.0, 0.0, 0.0);
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}