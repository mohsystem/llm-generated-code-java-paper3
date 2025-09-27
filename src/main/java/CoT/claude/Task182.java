package CoT.claude;

public class Task182 {
    public static String cleanPhoneNumber(String phoneNumber) {
        // Remove all non-digit characters
        String cleaned = phoneNumber.replaceAll("[^0-9]", "");
        
        // Remove leading 1 if present
        if (cleaned.length() == 11 && cleaned.charAt(0) == '1') {
            cleaned = cleaned.substring(1);
        }
        
        // Validate length and first digit
        if (cleaned.length() != 10 || cleaned.charAt(0) < '2') {
            return "Invalid phone number";
        }
        
        return cleaned;
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "+1 (613)-995-0253",
            "613-995-0253",
            "1 613 995 0253",
            "613.995.0253",
            "123-456-7890"
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + cleanPhoneNumber(test));
            System.out.println();
        }
    }
}
