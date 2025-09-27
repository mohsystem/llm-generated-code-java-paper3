package ZeroShot.llama31;
public class Task9 {
    public static void main(String[] args) {
        int[][] testCases = {
            {0},
            {0, 1, 4},
            {0, -1, -5},
            {1, 3, 5},
            {-2, -4, -6}
        };
        for (int[] testCase : testCases) {
            System.out.println(isSumOddOrEven(testCase));
        }
    }

    public static String isSumOddOrEven(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum % 2 == 0 ? "even" : "odd";
    }
}