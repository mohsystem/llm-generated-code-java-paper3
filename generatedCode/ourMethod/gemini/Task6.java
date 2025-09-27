package ourMethod.gemini;
import java.util.Arrays;

class Task6 {
    public static double findUniq(double arr[]) {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException("Array must contain at least 3 numbers.");
        }

        Arrays.sort(arr);

        if (arr[0] != arr[1]) {
            return arr[0];
        } else {
            return arr[arr.length - 1];
        }
    }

    public static void main(String[] args) {
        double[] test1 = {1, 1, 1, 2, 1, 1};
        double[] test2 = {0, 0, 0.55, 0, 0};
        double[] test3 = {2, 1, 1, 1, 1, 1};
        double[] test4 = {10, 10, 5, 10, 10};
        double[] test5 = {8, 8, 8, 8, 7};

        System.out.println(findUniq(test1)); // Expected output: 2.0
        System.out.println(findUniq(test2)); // Expected output: 0.55
        System.out.println(findUniq(test3)); // Expected output: 2.0
        System.out.println(findUniq(test4)); // Expected output: 5.0
        System.out.println(findUniq(test5)); // Expected output: 7.0


    }
}