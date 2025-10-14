package ZeroShot.openai;
import java.util.Arrays;

public class Task143 {

    public int[] sortArray(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        Task143 task = new Task143();

        int[] test1 = {5, 2, 9, 1, 5, 6};
        int[] test2 = {3, 0, -2, 5, 1};
        int[] test3 = {10, 20, 30, 40, 50};
        int[] test4 = {4, 3, 2, 1};
        int[] test5 = {0};

        System.out.println(Arrays.toString(task.sortArray(test1)));
        System.out.println(Arrays.toString(task.sortArray(test2)));
        System.out.println(Arrays.toString(task.sortArray(test3)));
        System.out.println(Arrays.toString(task.sortArray(test4)));
        System.out.println(Arrays.toString(task.sortArray(test5)));
    }
}