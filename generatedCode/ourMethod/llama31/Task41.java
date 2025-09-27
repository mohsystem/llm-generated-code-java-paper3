package ourMethod.llama31;
public class Task41 {
    public static void main(String[] args) {
        String inputStr = getUserInput();
        processString(inputStr);
    }

    public static String getUserInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    public static void processString(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            System.out.println("Input string is empty or null.");
            return;
        }
        System.out.println("Processed string: " + inputStr);
    }

    public static void mainWithTestCases() {
        String[] testCases = {"Hello, World!", "This is a test string", "", null, "Very long string to test buffer overflow safety"};
        for (String testCase : testCases) {
            processString(testCase);
        }
    }
}