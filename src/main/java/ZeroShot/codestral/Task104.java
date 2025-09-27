package ZeroShot.codestral;
public class Task104 {
    public static void handleUserInput(String input, char[] buffer) {
        if (input.length() > buffer.length) {
            throw new IllegalArgumentException("Input is too large for the buffer");
        }

        for (int i = 0; i < input.length(); i++) {
            buffer[i] = input.charAt(i);
        }
    }

    public static void main(String[] args) {
        char[] buffer = new char[10];

        // Test cases
        String[] inputs = {"Hello", "World", "Java", "Programming", "Secure"};

        for (String input : inputs) {
            try {
                handleUserInput(input, buffer);
                System.out.println("Successfully handled input: " + input);
            } catch (IllegalArgumentException e) {
                System.out.println("Failed to handle input: " + input + " - " + e.getMessage());
            }
        }
    }
}