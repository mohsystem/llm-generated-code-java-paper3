package ZeroShot.gemini;
import java.util.HashMap;
import java.util.Map;

class Task26 {
    public int findOdd(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return -1; // Should never reach here according to problem statement
    }

    public static void main(String[] args) {
        Task26 task = new Task26();
        int[] test1 = {7};
        int[] test2 = {0};
        int[] test3 = {1, 1, 2};
        int[] test4 = {0, 1, 0, 1, 0};
        int[] test5 = {1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1};

        System.out.println(task.findOdd(test1)); // Expected: 7
        System.out.println(task.findOdd(test2)); // Expected: 0
        System.out.println(task.findOdd(test3)); // Expected: 2
        System.out.println(task.findOdd(test4)); // Expected: 0
        System.out.println(task.findOdd(test5)); // Expected: 4
    }
}