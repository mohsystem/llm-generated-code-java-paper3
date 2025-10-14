package CoT.openai;
public class Task6 {
    public static double findUniq(double[] arr) {
        double a = arr[0], b = arr[1], c = arr[2];
        if (a != b && a != c) return a;
        for (double num : arr) {
            if (num != a) return num;
        }
        return -1; // should never reach here
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); // => 2
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0})); // => 0.55
        System.out.println(findUniq(new double[]{3, 3, 2, 3, 3})); // => 2
        System.out.println(findUniq(new double[]{4, 4, 4, 4, 5})); // => 5
        System.out.println(findUniq(new double[]{6, 7, 6, 6, 6})); // => 7
    }
}