package ourMethod.codestral;
import java.util.HashMap;
import java.util.Map;

public class Task6 {
    public static double findUniq(double arr[]) {
        Map<Double, Integer> counts = new HashMap<>();
        for (double num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (double num : arr) {
            if (counts.get(num) == 1) {
                return num;
            }
        }
        return -1; // should not reach here
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{ 1, 1, 1, 2, 1, 1 })); // => 2.0
        System.out.println(findUniq(new double[]{ 0, 0, 0.55, 0, 0 })); // => 0.55
    }
}