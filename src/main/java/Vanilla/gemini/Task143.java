package Vanilla.gemini;
import java.util.Arrays;

class Task143 {
    public int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        Task143 task = new Task143();
        int[] test1 = {5, 2, 9, 1, 5, 6};
        System.out.println(Arrays.toString(task.sortArray(test1))); // Output: [1, 2, 5, 5, 6, 9]

        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(task.sortArray(test2))); // Output: [1, 2, 3, 4, 5]

        int[] test3 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(task.sortArray(test3))); // Output: [1, 2, 3, 4, 5]

        int[] test4 = {};
        System.out.println(Arrays.toString(task.sortArray(test4))); // Output: []

        int[] test5 = {0, 0, 0, 0};
        System.out.println(Arrays.toString(task.sortArray(test5))); // Output: [0, 0, 0, 0]

    }
}