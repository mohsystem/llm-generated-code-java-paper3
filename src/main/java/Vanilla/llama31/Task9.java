package Vanilla.llama31;
public class Task9 {
    public static String isSumOddOrEven(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum % 2 == 0 ? "even" : "odd";
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {0},
            {0, 1, 4},
            {0, -1, -5},
            {},
            {2, 4, 6}
        };

        for (int[] testCase : testCases) {
            System.out.println(isSumOddOrEven(testCase));
        }
    }
}