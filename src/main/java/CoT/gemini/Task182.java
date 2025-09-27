package CoT.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task182 {
    public static String cleanPhoneNumber(String phoneNumber) {
        // Remove non-digit characters and the country code if present
        String cleanedNumber = phoneNumber.replaceAll("[^0-9]", "");
        if (cleanedNumber.startsWith("1") && cleanedNumber.length() == 11) {
            cleanedNumber = cleanedNumber.substring(1);
        }
        return cleanedNumber;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "+1 (613)-995-0253",
                "613-995-0253",
                "1 613 995 0253",
                "613.995.0253",
                "16139950253"
        };

        for (String testCase : testCases) {
            String cleanedNumber = cleanPhoneNumber(testCase);
            System.out.println(cleanedNumber);
        }
    }
}