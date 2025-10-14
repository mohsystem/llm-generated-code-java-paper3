package ourMethod.openai;
public class Task182 {
    public static String cleanPhoneNumber(String input) {
        input = input.replaceAll("[^0-9]", ""); // Remove all non-numeric characters
        if (input.startsWith("1") && input.length() == 11) {
            input = input.substring(1); // Remove the country code
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println(cleanPhoneNumber("+1 (613)-995-0253")); // 6139950253
        System.out.println(cleanPhoneNumber("613-995-0253"));     // 6139950253
        System.out.println(cleanPhoneNumber("1 613 995 0253"));   // 6139950253
        System.out.println(cleanPhoneNumber("613.995.0253"));     // 6139950253
        System.out.println(cleanPhoneNumber("1234567890"));       // 234567890
    }
}