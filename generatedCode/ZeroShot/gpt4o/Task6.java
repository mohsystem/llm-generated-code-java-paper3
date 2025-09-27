package ZeroShot.gpt4o;
public class Task6 {

    public static double findUniq(double[] arr) {
        double unique = arr[0];
        if (arr[0] != arr[1] && arr[0] != arr[2]) {
            unique = arr[0];
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[0]) {
                    unique = arr[i];
                    break;
                }
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); // => 2
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0})); // => 0.55
        System.out.println(findUniq(new double[]{5, 5, 5, 5, 3})); // => 3
        System.out.println(findUniq(new double[]{10, 10, 10, 20})); // => 20
        System.out.println(findUniq(new double[]{7, 8, 7, 7, 7})); // => 8
    }
}