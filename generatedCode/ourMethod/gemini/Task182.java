package ourMethod.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task182 {
    public String cleanPhoneNumber(String phoneNumber) {
        String cleanedNumber = phoneNumber.replaceAll("[^0-9]", "");
        if (cleanedNumber.startsWith("1") && cleanedNumber.length() > 10) {
            cleanedNumber = cleanedNumber.substring(1);
        }
         if (cleanedNumber.length() != 10) {
            return null;
        }
       
        return cleanedNumber;
    }

    public static void main(String[] args) {
        Task182 task = new Task182();
        String[] testCases = {
            "+1 (613)-995-0253",
            "613-995-0253",
            "1 613 995 0253",
            "613.995.0253",
            "1234567890"
        };
        for (String testCase : testCases) {
            String cleanedNumber = task.cleanPhoneNumber(testCase);
            System.out.println(cleanedNumber);
        }
    }
}