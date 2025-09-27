package ourMethod.codestral;
public class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        // Validating input length
        if (numbers.length != 10) {
            throw new IllegalArgumentException("Input array must have exactly 10 elements");
        }

        // Validating input range
        for (int number : numbers) {
            if (number < 0 || number > 9) {
                throw new IllegalArgumentException("Input array elements must be between 0 and 9");
            }
        }

        // Formatting phone number
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0})); // => returns "(123) 456-7890"
    }
}