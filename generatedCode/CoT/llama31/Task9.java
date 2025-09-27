package CoT.llama31;
public class Task9 {
    public static String isSumOddOrEven(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        // If array is empty, consider sum as 0
        if (arr.length == 0) {
            sum = 0;
        }
        return sum % 2 == 0 ? "even" : "odd";
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {0},
            {0, 1, 4},
            {0, -1, -5},
            {},
            {1, 3, 5}
        };
        for (int[] testCase : testCases) {
            System.out.println("Input: " + java.util.Arrays.toString(testCase));
            System.out.println("Output: " + isSumOddOrEven(testCase));
            System.out.println();
        }
    }
}