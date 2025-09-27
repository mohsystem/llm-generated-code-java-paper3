package ZeroShot.gpt4o;
public class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        if (numbers == null || numbers.length != 10) {
            throw new IllegalArgumentException("Array must contain exactly 10 integers.");
        }
        for (int num : numbers) {
            if (num < 0 || num > 9) {
                throw new IllegalArgumentException("Each integer must be between 0 and 9.");
            }
        }
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2],
                numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        System.out.println(createPhoneNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(createPhoneNumber(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        System.out.println(createPhoneNumber(new int[]{3, 3, 3, 4, 4, 4, 5, 5, 5, 5}));
        System.out.println(createPhoneNumber(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}