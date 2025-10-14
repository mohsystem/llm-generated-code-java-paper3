package ourMethodv2.gpt4o;
public class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        if (numbers == null || numbers.length != 10) {
            throw new IllegalArgumentException("Input array must contain exactly 10 integers.");
        }
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append("(");
        for (int i = 0; i < 3; i++) {
            phoneNumber.append(numbers[i]);
        }
        phoneNumber.append(") ");
        for (int i = 3; i < 6; i++) {
            phoneNumber.append(numbers[i]);
        }
        phoneNumber.append("-");
        for (int i = 6; i < 10; i++) {
            phoneNumber.append(numbers[i]);
        }
        return phoneNumber.toString();
    }

    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})); // "(123) 456-7890"
        System.out.println(createPhoneNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})); // "(012) 345-6789"
        System.out.println(createPhoneNumber(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})); // "(987) 654-3210"
        System.out.println(createPhoneNumber(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5})); // "(555) 555-5555"
        System.out.println(createPhoneNumber(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1})); // "(111) 111-1111"
    }
}