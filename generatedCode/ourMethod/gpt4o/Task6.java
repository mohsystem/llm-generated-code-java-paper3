package ourMethod.openai;
public class Task6 {
    public static double findUniq(double[] arr) {
        double a = arr[0];
        if (a != arr[1] && a != arr[2]) {
            return a;
        }
        for (double num : arr) {
            if (num != a) {
                return num;
            }
        }
        throw new IllegalArgumentException("No unique number found");
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{ 1, 1, 1, 2, 1, 1 })); // 2
        System.out.println(findUniq(new double[]{ 0, 0, 0.55, 0, 0 })); // 0.55
        System.out.println(findUniq(new double[]{ 3, 3, 3, 3, 4 })); // 4
        System.out.println(findUniq(new double[]{ 2, 2, 1, 2, 2 })); // 1
        System.out.println(findUniq(new double[]{ 5, 5, 5, 5, 6 })); // 6
    }
}