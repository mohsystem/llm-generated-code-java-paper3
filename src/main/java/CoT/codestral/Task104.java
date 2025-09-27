package CoT.codestral;
public class Task104 {
    public static void handleUserInput(char[] buffer, String userInput) {
        if (userInput.length() > buffer.length) {
            throw new IllegalArgumentException("User input exceeds buffer size");
        }

        for (int i = 0; i < userInput.length(); i++) {
            buffer[i] = userInput.charAt(i);
        }
    }

    public static void main(String[] args) {
        char[] buffer = new char[10];
        String[] testCases = {"Hello", "World", "Java", "Coding", "Secure"};

        for (String testCase : testCases) {
            try {
                handleUserInput(buffer, testCase);
                System.out.println("Input: " + testCase + ", Buffer: " + new String(buffer));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}