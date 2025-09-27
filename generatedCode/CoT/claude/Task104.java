package CoT.claude;

public class Task104 {
    private static final int BUFFER_SIZE = 100;
    
    public static String handleInput(String input) {
        if (input == null) {
            return "";
        }
        
        // Create fixed size buffer
        char[] buffer = new char[BUFFER_SIZE];
        
        // Safely copy input to buffer with bounds checking
        int length = Math.min(input.length(), BUFFER_SIZE - 1);
        for (int i = 0; i < length; i++) {
            buffer[i] = input.charAt(i);
        }
        buffer[length] = '\\0'; // Null terminate
        
        return new String(buffer, 0, length);
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World",
            "This is a very long input that exceeds the buffer size limit and should be truncated safely",
            "",
            null,
            "Test123!@#"
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + handleInput(test));
            System.out.println();
        }
    }
}
