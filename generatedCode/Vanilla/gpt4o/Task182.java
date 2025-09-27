package Vanilla.gpt4o;
public class Task182 {
    public static String cleanPhoneNumber(String input) {
        String cleaned = input.replaceAll("[^0-9]", "");
        if (cleaned.startsWith("1") && cleaned.length() == 11) {
            cleaned = cleaned.substring(1);
        }
        return cleaned;
    }

    public static void main(String[] args) {
        System.out.println(cleanPhoneNumber("+1 (613)-995-0253")); // 6139950253
        System.out.println(cleanPhoneNumber("613-995-0253")); // 6139950253
        System.out.println(cleanPhoneNumber("1 613 995 0253")); // 6139950253
        System.out.println(cleanPhoneNumber("613.995.0253")); // 6139950253
        System.out.println(cleanPhoneNumber("+1-800-555-2468")); // 8005552468
    }
}