package ourMethodv2.gpt4o;
public class Task6 {
    public static double findUniq(double[] arr) {
        double unique = arr[0] == arr[1] ? arr[0] : arr[2];
        for (double num : arr) {
            if (num != unique) {
                return num;
            }
        }
        return unique; // in case the unique number is the first element
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); // => 2
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0})); // => 0.55
        System.out.println(findUniq(new double[]{3, 3, 4, 3, 3})); // => 4
        System.out.println(findUniq(new double[]{5, 5, 5, 5, 6})); // => 6
        System.out.println(findUniq(new double[]{7, 8, 7, 7, 7})); // => 8
    }
}