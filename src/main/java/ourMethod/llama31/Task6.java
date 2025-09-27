package ourMethod.llama31;
public class Task6 {
    public static double findUniq(double[] arr) {
        double first = arr[0];
        double second = arr[1];
        if (first != second && first == arr[2]) {
            return second;
        } else {
            return first;
        }
    }

    public static void main(String[] args) {
        double[] test1 = {1, 1, 1, 2, 1, 1};
        double[] test2 = {0, 0, 0.55, 0, 0};
        double[] test3 = {3, 3, 3, 4, 3, 3};
        double[] test4 = {5, 5, 5, 5, 6};
        double[] test5 = {7, 7, 7, 8, 7};

        System.out.println(findUniq(test1)); // => 2
        System.out.println(findUniq(test2)); // => 0.55
        System.out.println(findUniq(test3)); // => 4
        System.out.println(findUniq(test4)); // => 6
        System.out.println(findUniq(test5)); // => 8
    }
}