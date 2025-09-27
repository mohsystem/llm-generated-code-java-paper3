package CoT.gemini;
import java.util.Arrays;

class Task6 {
    public static double findUniq(double[] arr) {
        Arrays.sort(arr);
        if (arr[0] == arr[1]) {
            return arr[arr.length - 1];
        } else {
            return arr[0];
        }
    }

    public static void main(String[] args) {
        double[] test1 = {1, 1, 1, 2, 1, 1};
        double[] test2 = {0, 0, 0.55, 0, 0};
        double[] test3 = {2, 1, 1, 1, 1, 1};
        double[] test4 = {10, 10, 10, 5, 10};
        double[] test5 = {8, 8, 8, 8, 9};

        System.out.println(findUniq(test1)); // Output: 2.0
        System.out.println(findUniq(test2)); // Output: 0.55
        System.out.println(findUniq(test3)); // Output: 2.0
        System.out.println(findUniq(test4)); // Output: 5.0
        System.out.println(findUniq(test5)); // Output: 9.0


    }
}