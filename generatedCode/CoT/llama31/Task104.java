package CoT.llama31;
public class Task104 {
    public static void main(String[] args) {
        // Test cases
        String[] inputs = {"Hello", "This is a test string", "Buffer overflow attempt with a very long string"};
        for (String input : inputs) {
            handleUserInput(input);
        }
    }

    public static void handleUserInput(String input) {
        int bufferSize = 20; // Fixed buffer size
        char[] buffer = new char[bufferSize];

        // Securely copy input into buffer
        int length = Math.min(input.length(), bufferSize);
        input.getChars(0, length, buffer, 0);

        // Print the buffered input
        System.out.println("Buffered Input: " + new String(buffer, 0, length));
    }
}