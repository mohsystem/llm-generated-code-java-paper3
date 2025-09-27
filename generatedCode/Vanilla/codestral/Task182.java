package Vanilla.codestral;
public class Task182 {
    public static String cleanPhoneNumber(String number) {
        return number.replaceAll("[^\\d]", "");
    }

    public static void main(String[] args) {
        System.out.println(cleanPhoneNumber("+1 (613)-995-0253")); // 6139950253
        System.out.println(cleanPhoneNumber("613-995-0253")); // 6139950253
        System.out.println(cleanPhoneNumber("1 613 995 0253")); // 6139950253
        System.out.println(cleanPhoneNumber("613.995.0253")); // 6139950253
    }
}