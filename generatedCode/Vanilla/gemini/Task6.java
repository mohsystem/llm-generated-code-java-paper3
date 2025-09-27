package Vanilla.gemini;
import java.util.Arrays;

class Task6 {
    public static double findUniq(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); // => 2
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0})); // => 0.55
        System.out.println(findUniq(new double[]{2, 1, 1, 1, 1, 1})); // => 2
        System.out.println(findUniq(new double[]{10, 3, 3, 3, 3})); // => 10
        System.out.println(findUniq(new double[]{8, 8, 8, 8, 7})); // => 7


    }
}