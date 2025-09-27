package Vanilla.llama31;
public class Task89 {
    public static boolean comparePasswords(String storedPassword, String userInput) {
        if (storedPassword.length() != userInput.length()) {
            return false;
        }
        for (int i = 0; i < storedPassword.length(); i++) {
            if (storedPassword.charAt(i) != userInput.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String storedPassword = "historia";
        String[] testCases = {"historia", "history", "histo", "historias", "other"};
        for (String testCase : testCases) {
            System.out.println("Password: " + testCase + " - " + (comparePasswords(storedPassword, testCase) ? "Valid" : "Invalid"));
        }
    }
}