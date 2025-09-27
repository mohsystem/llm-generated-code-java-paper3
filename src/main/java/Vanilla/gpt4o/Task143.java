package Vanilla.gpt4o;
import java.util.Arrays;

public class Task143 {
    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] test1 = {5, 2, 9, 1, 5, 6};
        int[] test2 = {3, 0, -2, 5, 1, 2};
        int[] test3 = {1, 2, 3, 4, 5};
        int[] test4 = {5, 4, 3, 2, 1};
        int[] test5 = {10, 8, 12, 15, 3};

        System.out.println(Arrays.toString(sortArray(test1)));
        System.out.println(Arrays.toString(sortArray(test2)));
        System.out.println(Arrays.toString(sortArray(test3)));
        System.out.println(Arrays.toString(sortArray(test4)));
        System.out.println(Arrays.toString(sortArray(test5)));
    }
}