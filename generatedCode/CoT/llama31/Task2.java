package CoT.llama31;
public class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        // Problem understanding: Convert array of integers into a phone number format
        // Security requirements: Ensure input array is of correct length and contains valid integers

        if (numbers.length != 10) {
            throw new IllegalArgumentException("Input array must be of length 10");
        }

        // Secure coding generation: Format the phone number step-by-step
        String phoneNumber = "(" + numbers[0] + numbers[1] + numbers[2] + ") " +
                             numbers[3] + numbers[4] + numbers[5] + "-" +
                             numbers[6] + numbers[7] + numbers[8] + numbers[9];

        return phoneNumber;
    }

    public static void main(String[] args) {
        // Test cases
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] test2 = {5, 1, 9, 5, 5, 5, 4, 4, 6, 8};
        int[] test3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] test4 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] test5 = {4, 3, 2, 1, 0, 9, 8, 7, 6, 5};

        System.out.println(createPhoneNumber(test1)); // => returns "(123) 456-7890"
        System.out.println(createPhoneNumber(test2)); // => returns "(519) 555-4468"
        System.out.println(createPhoneNumber(test3)); // => returns "(000) 000-0000"
        System.out.println(createPhoneNumber(test4)); // => returns "(987) 654-3210"
        System.out.println(createPhoneNumber(test5)); // => returns "(432) 109-8765"
    }
}