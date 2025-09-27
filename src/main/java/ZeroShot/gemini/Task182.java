package ZeroShot.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task182 {
    public String cleanPhoneNumber(String phoneNumber) {
        String cleanedNumber = phoneNumber.replaceAll("[^0-9]", "");
        if (cleanedNumber.startsWith("1") && cleanedNumber.length() == 11) {
            return cleanedNumber.substring(1);
        }
        if (cleanedNumber.length() == 10) {
            return cleanedNumber;
        }

        return null; // Or throw an exception or return an empty string
    }

    public static void main(String[] args) {
        Task182 task182 = new Task182();
        String[] testCases = {"+1 (613)-995-0253", "613-995-0253", "1 613 995 0253", "613.995.0253", "1234567890123"};
        for (String testCase : testCases) {
            System.out.println(task182.cleanPhoneNumber(testCase));
        }

    }
}