package CoT.gemini;
import java.util.Arrays;

class Task143 {
    public int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        Task143 task = new Task143();

        int[] test1 = {5, 2, 8, 1, 9, 4};
        System.out.println(Arrays.toString(task.sortArray(test1))); // Output: [1, 2, 4, 5, 8, 9]

        int[] test2 = {10, -5, 0, 3, -2};
        System.out.println(Arrays.toString(task.sortArray(test2))); // Output: [-5, -2, 0, 3, 10]

        int[] test3 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(task.sortArray(test3))); // Output: [1, 2, 3, 4, 5]

        int[] test4 = {};
        System.out.println(Arrays.toString(task.sortArray(test4))); // Output: []

        int[] test5 = {5};
        System.out.println(Arrays.toString(task.sortArray(test5))); // Output: [5]
    }
}