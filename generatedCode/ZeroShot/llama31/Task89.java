package ZeroShot.llama31;
public static void main(String[] args) {
    String filename = "password.txt";
    String storedPassword = readPasswordFromFile(filename);
    if (storedPassword != null) {
        String[] testCases = {
            "correctPassword",
            "incorrectPassword",
            "anotherIncorrect",
            "yetAnotherIncorrect",
            "correctPasswordAgain"
        };
        for (String testCase : testCases) {
            if (comparePasswords(storedPassword, testCase)) {
                System.out.println("Passwords match for test case: " + testCase);
            } else {
                System.out.println("Passwords do not match for test case: " + testCase);
            }
        }
    }
}