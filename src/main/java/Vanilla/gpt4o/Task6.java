package Vanilla.gpt4o;
public class Task6 {
    public static double findUniq(double[] arr) {
        if (arr[0] != arr[1] && arr[0] != arr[2]) {
            return arr[0];
        }
        for (double num : arr) {
            if (num != arr[0]) {
                return num;
            }
        }
        return -1; // Default return value, should never be reached
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); // => 2
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0})); // => 0.55
        System.out.println(findUniq(new double[]{3, 3, 3, 3, 4, 3})); // => 4
        System.out.println(findUniq(new double[]{5, 6, 5, 5, 5, 5})); // => 6
        System.out.println(findUniq(new double[]{7, 7, 7, 7, 7, 8})); // => 8
    }
}