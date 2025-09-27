package ourMethod.gemini;
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
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);

    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] test2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] test3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] test4 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] test5 = {5, 5, 5, 1, 2, 3, 4, 5, 6, 7};



        System.out.println(createPhoneNumber(test1));
        System.out.println(createPhoneNumber(test2));
        System.out.println(createPhoneNumber(test3));
        System.out.println(createPhoneNumber(test4));
        System.out.println(createPhoneNumber(test5));

    }
}