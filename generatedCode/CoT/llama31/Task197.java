package CoT.llama31;
import java.util.Random;

public class Task197 {
    private double radius;
    private double xCenter;
    private double yCenter;
    private Random rand;

    public Task197(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.rand = new Random();
    }

    public double[] randPoint() {
        double angle = rand.nextDouble() * 2 * Math.PI;
        double hyp = Math.sqrt(rand.nextDouble()) * radius;
        double adj = Math.cos(angle) * hyp;
        double opp = Math.sin(angle) * hyp;
        return new double[]{xCenter + adj, yCenter + opp};
    }

    public static void main(String[] args) {
        Task197 solution = new Task197(1.0, 0.0, 0.0);
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}