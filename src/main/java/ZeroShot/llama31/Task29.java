package ZeroShot.llama31;
// Java code
public class Task29 {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null; // This line should not be reached based on the problem description
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3},
            {3, 2, 4},
            {10, 20, 30, 40},
            {5, 10, 15, 20},
            {1, 3, 5, 7}
        };
        int[] targets = {4, 6, 50, 30, 8};

        for (int i = 0; i < testCases.length; i++) {
            int[] result = twoSum(testCases[i], targets[i]);
            System.out.println("twoSum(" + java.util.Arrays.toString(testCases[i]) + ", " + targets[i] + ") == (" + result[0] + ", " + result[1] + ")");
        }
    }
}