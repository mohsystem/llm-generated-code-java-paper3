package ZeroShot.codestral;
import java.util.Arrays;

public class Task6 {
    public static double findUniq(double[] arr) {
        Arrays.sort(arr);
        if (arr[0] == arr[1]) {
            return arr[arr.length - 1];
        } else {
            return arr[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{ 1, 1, 1, 2, 1, 1 })); // => 2.0
        System.out.println(findUniq(new double[]{ 0, 0, 0.55, 0, 0 })); // => 0.55
    }
}