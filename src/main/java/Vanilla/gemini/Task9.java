package Vanilla.gemini;
import java.util.Arrays;
import java.util.List;

class Task9 {
    public String oddOrEven(List<Integer> array) {
        int sum = 0;
        if (array == null || array.isEmpty()) {
            sum = 0;
        } else {
            for (int num : array) {
                sum += num;
            }
        }
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        Task9 task9 = new Task9();

        List<Integer> test1 = Arrays.asList(0);
        System.out.println(task9.oddOrEven(test1)); // Output: even

        List<Integer> test2 = Arrays.asList(0, 1, 4);
        System.out.println(task9.oddOrEven(test2)); // Output: odd

        List<Integer> test3 = Arrays.asList(0, -1, -5);
        System.out.println(task9.oddOrEven(test3)); // Output: even

        List<Integer> test4 = null;
        System.out.println(task9.oddOrEven(test4)); // Output: even

        List<Integer> test5 = Arrays.asList();
        System.out.println(task9.oddOrEven(test5)); // Output: even

    }
}