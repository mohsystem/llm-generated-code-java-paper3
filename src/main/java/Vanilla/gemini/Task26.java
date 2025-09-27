package Vanilla.gemini;
import java.util.HashMap;
import java.util.Map;

class Task26 {
    public static int findOdd(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return -1; // Should not reach here as per problem statement
    }

    public static void main(String[] args) {
        int[] test1 = {7};
        int[] test2 = {0};
        int[] test3 = {1, 1, 2};
        int[] test4 = {0, 1, 0, 1, 0};
        int[] test5 = {1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1};

        System.out.println(findOdd(test1)); // Output: 7
        System.out.println(findOdd(test2)); // Output: 0
        System.out.println(findOdd(test3)); // Output: 2
        System.out.println(findOdd(test4)); // Output: 0
        System.out.println(findOdd(test5)); // Output: 4
    }
}