package ourMethod.gemini;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Task29 {
    public static int[] two_sum(int[] numbers, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(numbers[i], i);
        }
        return new int[0]; // Should not reach here as per problem statement
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int target1 = 4;
        System.out.println(Arrays.toString(two_sum(test1, target1))); // Output: [0, 2]

        int[] test2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(two_sum(test2, target2))); // Output: [1, 2]

        int[] test3 = {10, 20, 30, 40};
        int target3 = 50;
        System.out.println(Arrays.toString(two_sum(test3, target3))); // Output: [1, 2]

        int[] test4 = {1, -2, 3, 4};
        int target4 = 2;
        System.out.println(Arrays.toString(two_sum(test4, target4))); // Output: [1, 2]

        int[] test5 = {2, 2, 3};
        int target5 = 4;
        System.out.println(Arrays.toString(two_sum(test5, target5))); // Output: [0, 1]
    }
}