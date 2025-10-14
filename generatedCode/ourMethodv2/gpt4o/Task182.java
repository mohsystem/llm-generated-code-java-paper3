package ourMethodv2.gpt4o;
public class Task182 {
    public static String cleanNumber(String phoneNumber) {
        String cleaned = phoneNumber.replaceAll("[^0-9]", "");
        if (cleaned.startsWith("1") && cleaned.length() == 11) {
            cleaned = cleaned.substring(1);
        }
        return cleaned;
    }

    public static void main(String[] args) {
        System.out.println(cleanNumber("+1 (613)-995-0253")); // 6139950253
        System.out.println(cleanNumber("613-995-0253"));       // 6139950253
        System.out.println(cleanNumber("1 613 995 0253"));     // 6139950253
        System.out.println(cleanNumber("613.995.0253"));       // 6139950253
        System.out.println(cleanNumber("1 (613) 995-0253"));   // 6139950253
    }
}