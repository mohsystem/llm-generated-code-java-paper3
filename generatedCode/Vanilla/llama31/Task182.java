package Vanilla.llama31;
public class Task182 {
    public static void main(String[] args) {
        String[] testCases = {
            "+1 (613)-995-0253",
            "613-995-0253",
            "1 613 995 0253",
            "613.995.0253",
            "(613) 995-0253"
        };

        for (String testCase : testCases) {
            System.out.println(cleanPhoneNumber(testCase));
        }
    }

    public static String cleanPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        if (phoneNumber.length() > 10) {
            phoneNumber = phoneNumber.substring(phoneNumber.length() - 10);
        }
        return phoneNumber;
    }
}