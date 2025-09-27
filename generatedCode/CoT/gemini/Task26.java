package CoT.gemini;
import java.util.HashMap;
import java.util.Map;

public class Task26 {

    public static int findOddOccurrence(int[] arr) {
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

        System.out.println(findOddOccurrence(test1)); // Expected: 7
        System.out.println(findOddOccurrence(test2)); // Expected: 0
        System.out.println(findOddOccurrence(test3)); // Expected: 2
        System.out.println(findOddOccurrence(test4)); // Expected: 0
        System.out.println(findOddOccurrence(test5)); // Expected: 4
    }
}