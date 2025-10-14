package ourMethod.openai;
import java.util.Arrays;

public class Task143 {

    public int[] sortArray(int[] input) {
        int[] arr = input.clone(); // Clone to avoid modifying the original array
        Arrays.sort(arr); // Sort the array
        return arr;
    }

    public static void main(String[] args) {
        Task143 task = new Task143();

        int[] test1 = {3, 1, 4, 1, 5, 9};
        int[] result1 = task.sortArray(test1);
        System.out.println(Arrays.toString(result1));

        int[] test2 = {2, 7, 1, 8, 2, 8};
        int[] result2 = task.sortArray(test2);
        System.out.println(Arrays.toString(result2));

        int[] test3 = {5, 0, 3, 9, 8, 9};
        int[] result3 = task.sortArray(test3);
        System.out.println(Arrays.toString(result3));

        int[] test4 = {1, 1, 2, 3, 5, 8};
        int[] result4 = task.sortArray(test4);
        System.out.println(Arrays.toString(result4));

        int[] test5 = {9, 7, 4, 6, 5, 3};
        int[] result5 = task.sortArray(test5);
        System.out.println(Arrays.toString(result5));
    }
}