package ourMethod.llama31;
public class Task182 {
    public static String cleanPhoneNumber(String phoneNumber) {
        // Remove country code
        phoneNumber = phoneNumber.replaceAll("^\\+?1\\s?", "");
        // Remove punctuation
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        return phoneNumber;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "+1 (613)-995-0253",
            "613-995-0253",
            "1 613 995 0253",
            "613.995.0253"
        };
        for (String testCase : testCases) {
            System.out.println(cleanPhoneNumber(testCase));
        }
    }
}