package ZeroShot.claude;

public class Task182 {
    public static String cleanPhoneNumber(String phoneNumber) {
        // Remove all non-digit characters
        String cleaned = phoneNumber.replaceAll("[^0-9]", "");
        
        // Remove leading 1 if present
        if (cleaned.startsWith("1") && cleaned.length() == 11) {
            cleaned = cleaned.substring(1);
        }
        
        // Validate length and first digit
        if (cleaned.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number length");
        }
        
        if (cleaned.charAt(0) < '2' || cleaned.charAt(0) > '9') {
            throw new IllegalArgumentException("Area code must start with 2-9");
        }
        
        if (cleaned.charAt(3) < '2' || cleaned.charAt(3) > '9') {
            throw new IllegalArgumentException("Exchange code must start with 2-9");
        }
        
        return cleaned;
    }
    
    public static void main(String[] args) {
        String[] testCases = {
            "+1 (613)-995-0253",
            "613-995-0253",
            "1 613 995 0253",
            "613.995.0253",
            "223-456-7890"
        };
        
        for (String test : testCases) {
            try {
                System.out.println("Input: " + test);
                System.out.println("Output: " + cleanPhoneNumber(test));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }
}
