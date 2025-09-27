package CoT.gemini;
import java.util.Arrays;

class Task14 {
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            int rightSum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 3, 2, 1};
        int[] test2 = {1, 100, 50, -51, 1, 1};
        int[] test3 = {20, 10, -80, 10, 10, 15, 35};
        int[] test4 = {1, 2, 3, 4, 5};
        int[] test5 = {1};

        System.out.println(findEvenIndex(test1)); // Output: 3
        System.out.println(findEvenIndex(test2)); // Output: 1
        System.out.println(findEvenIndex(test3)); // Output: 0
        System.out.println(findEvenIndex(test4)); // Output: -1
        System.out.println(findEvenIndex(test5)); // Output: 0

    }
}