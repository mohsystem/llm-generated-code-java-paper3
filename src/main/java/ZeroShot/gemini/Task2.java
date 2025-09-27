package ZeroShot.gemini;
import java.util.Arrays;

class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        if (numbers.length != 10) {
            throw new IllegalArgumentException("The array must contain exactly 10 integers.");
        }
        for (int num : numbers) {
            if (num < 0 || num > 9) {
                throw new IllegalArgumentException("Numbers must be between 0 and 9.");
            }
        }
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4],
                numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        for (int[] testCase : testCases) {
            System.out.println(createPhoneNumber(testCase));
        }
    }
}