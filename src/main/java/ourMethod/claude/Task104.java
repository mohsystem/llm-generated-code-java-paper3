package ourMethod.claude;

public class Task104 {
    private static final int BUFFER_SIZE = 1024;

    public static String handleInput(String input) {
        if (input == null) {
            return "";
        }
        
        // Create fixed size buffer 
        char[] buffer = new char[BUFFER_SIZE];
        
        // Safely copy input to buffer with bounds checking
        int copyLength = Math.min(input.length(), BUFFER_SIZE-1);
        input.getChars(0, copyLength, buffer, 0);
        
        // Ensure null termination
        buffer[copyLength] = '\0';
        
        return new String(buffer, 0, copyLength);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(handleInput("Test string")); 
        System.out.println(handleInput(""));
        System.out.println(handleInput(null));
        System.out.println(handleInput("A very long string that exceeds buffer size...".repeat(50)));
        System.out.println(handleInput("Special chars: !@#$%^&*()"));
    }
}
