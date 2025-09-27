package ourMethod.llama31;
public class Task104 {
    public static void main(String[] args) {
        // Test cases
        String[] inputs = {"Hello", "This is a long string that should not overflow", "Short"};

        for (String input : inputs) {
            handleInput(input, 20); // Buffer size of 20 characters
        }
    }

    public static void handleInput(String input, int bufferSize) {
        if (input.length() > bufferSize) {
            System.out.println("Input too long. Truncating to " + bufferSize + " characters.");
            input = input.substring(0, bufferSize);
        }

        char[] buffer = new char[bufferSize];
        input.getChars(0, input.length(), buffer, 0);

        // Null-terminate the buffer if necessary
        for (int i = input.length(); i < bufferSize; i++) {
            buffer[i] = '\0';
        }

        System.out.println("Buffer contents: " + new String(buffer));
    }
}