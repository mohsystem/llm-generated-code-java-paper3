package ourMethod.llama31;
public class Task24 {
    public static boolean validatePin(String pin) {
        // Check if the length is either 4 or 6
        if (pin.length() != 4 && pin.length() != 6) {
            return false;
        }
        
        // Check if all characters are digits
        for (char c : pin.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {"1234", "12345", "a234", "123456", "abcdef"};
        for (String testCase : testCases) {
            System.out.println(testCase + ": " + validatePin(testCase));
        }
    }
}