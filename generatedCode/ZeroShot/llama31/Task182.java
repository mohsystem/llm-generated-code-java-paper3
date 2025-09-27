package ZeroShot.llama31;
public class Task182 {
    public static String cleanPhoneNumber(String phoneNumber) {
        // Remove all non-digit characters except for the country code
        String cleaned = phoneNumber.replaceAll("[^0-9+]", "");
        
        // Remove the country code if present
        if (cleaned.startsWith("1") || cleaned.startsWith("+1")) {
            cleaned = cleaned.replaceFirst("1", "").replaceFirst("\\+", "");
        }
        
        return cleaned;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "+1 (613)-995-0253",
            "613-995-0253",
            "1 613 995 0253",
            "613.995.0253",
            "+16139950253"
        };

        for (String testCase : testCases) {
            System.out.println(cleanPhoneNumber(testCase));
        }
    }
}