package ourMethodv2.gpt4o;
import java.util.Arrays;

public class Task143 {
    public static int[] sortArray(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] test1 = {5, 3, 8, 6, 2};
        int[] test2 = {1, 2, 3, 4, 5};
        int[] test3 = {10, 9, 8, 7, 6};
        int[] test4 = {3, 1, 4, 1, 5, 9};
        int[] test5 = {};

        System.out.println(Arrays.toString(sortArray(test1)));
        System.out.println(Arrays.toString(sortArray(test2)));
        System.out.println(Arrays.toString(sortArray(test3)));
        System.out.println(Arrays.toString(sortArray(test4)));
        System.out.println(Arrays.toString(sortArray(test5)));
    }
}