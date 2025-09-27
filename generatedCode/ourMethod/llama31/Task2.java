package ourMethod.llama31;
public class Task2 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(createPhoneNumber(numbers));
    }

    public static String createPhoneNumber(int[] numbers) {
        if (numbers.length != 10) {
            throw new IllegalArgumentException("Array must have exactly 10 elements");
        }
        for (int number : numbers) {
            if (number < 0 || number > 9) {
                throw new IllegalArgumentException("All elements must be between 0 and 9");
            }
        }
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2],
                             numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }
}