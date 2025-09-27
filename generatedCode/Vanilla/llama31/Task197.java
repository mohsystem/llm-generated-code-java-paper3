package Vanilla.llama31;
import java.util.Random;

public class Task197 {
    private double RAD, XC, YC;
    private Random random;

    public Task197(double radius, double x_center, double y_center) {
        RAD = radius;
        XC = x_center;
        YC = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double ang = random.nextDouble() * 2 * Math.PI;
        double hyp = Math.sqrt(random.nextDouble()) * RAD;
        double adj = Math.cos(ang) * hyp;
        double opp = Math.sin(ang) * hyp;
        return new double[]{XC + adj, YC + opp};
    }

    public static void main(String[] args) {
        Task197 solution = new Task197(1.0, 0.0, 0.0);
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}