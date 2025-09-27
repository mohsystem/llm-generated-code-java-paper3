package ourMethod.gemini;
import java.util.Arrays;

public class Task143 {

    public static int[] sortArray(int[] arr) {
        if (arr == null) {
            return null; 
        }

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        return sortedArr;
    }

    public static void main(String[] args) {
        int[] test1 = {5, 2, 8, 1, 9, 4};
        int[] sortedTest1 = sortArray(test1);
        System.out.println(Arrays.toString(sortedTest1)); // Expected: [1, 2, 4, 5, 8, 9]

        int[] test2 = {1, 2, 3, 4, 5};
        int[] sortedTest2 = sortArray(test2);
        System.out.println(Arrays.toString(sortedTest2)); // Expected: [1, 2, 3, 4, 5]

        int[] test3 = {5, 4, 3, 2, 1};
        int[] sortedTest3 = sortArray(test3);
        System.out.println(Arrays.toString(sortedTest3)); // Expected: [1, 2, 3, 4, 5]

        int[] test4 = {};
        int[] sortedTest4 = sortArray(test4);
        System.out.println(Arrays.toString(sortedTest4)); // Expected: []

        int[] test5 = null;
        int[] sortedTest5 = sortArray(test5);
        System.out.println(Arrays.toString(sortedTest5)); // Expected: null

    }
}