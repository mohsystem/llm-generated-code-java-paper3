package CoT.llama31;
public class Task6 {
    public static double findUniq(double[] arr) {
        double first = arr[0];
        double second = arr[1];
        if (first != second) {
            for (double num : arr) {
                if (num != first) {
                    return num;
                }
            }
        } else {
            for (double num : arr) {
                if (num != first) {
                    return num;
                }
            }
        }
        return 0; // This line is technically unnecessary given the problem constraints
    }

    public static void main(String[] args) {
        double[] test1 = {1, 1, 1, 2, 1, 1};
        double[] test2 = {0, 0, 0.55, 0, 0};
        double[] test3 = {3, 3, 3, 4, 3, 3};
        double[] test4 = {5, 5, 5, 5, 6};
        double[] test5 = {7, 7, 8, 7, 7};

        System.out.println(findUniq(test1)); // => 2
        System.out.println(findUniq(test2)); // => 0.55
        System.out.println(findUniq(test3)); // => 4
        System.out.println(findUniq(test4)); // => 6
        System.out.println(findUniq(test5)); // => 8
    }
}