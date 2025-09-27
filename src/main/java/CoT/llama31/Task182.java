package CoT.llama31;
public class Task182 {
    public static String cleanPhoneNumber(String phoneNumber) {
        // Remove country code
        phoneNumber = phoneNumber.replace("+1", "").replace("1 ", "").trim();
        // Remove all non-digit characters
        return phoneNumber.replaceAll("[^0-9]", "");
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