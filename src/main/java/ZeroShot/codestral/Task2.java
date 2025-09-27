package ZeroShot.codestral;
public class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0})); // "(123) 456-7890"
        System.out.println(createPhoneNumber(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0})); // "(987) 654-3210"
        System.out.println(createPhoneNumber(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})); // "(012) 345-6789"
        System.out.println(createPhoneNumber(new int[] {5, 5, 5, 1, 2, 3, 4, 5, 6, 7})); // "(555) 123-4567"
        System.out.println(createPhoneNumber(new int[] {9, 9, 9, 9, 9, 9, 9, 9, 9, 9})); // "(999) 999-9999"
    }
}