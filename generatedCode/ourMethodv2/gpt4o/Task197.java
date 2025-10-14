package ourMethodv2.gpt4o;
import java.util.Random;

public class Task197 {
    static class Solution {
        private double radius;
        private double x_center;
        private double y_center;
        private Random rand;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
            this.rand = new Random();
        }

        public double[] randPoint() {
            while (true) {
                double x = rand.nextDouble() * 2 - 1;
                double y = rand.nextDouble() * 2 - 1;
                if (x * x + y * y <= 1) {
                    return new double[]{x_center + x * radius, y_center + y * radius};
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        for (int i = 0; i < 5; i++) {
            double[] point = solution.randPoint();
            System.out.println("Random Point: [" + point[0] + ", " + point[1] + "]");
        }
    }
}