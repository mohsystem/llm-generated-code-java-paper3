package ZeroShot.claude;

public class Task104 {
    public static String handleInput(String input, int bufferSize) {
        if (input == null) {
            return "";
        }
        
        // Create fixed size buffer
        char[] buffer = new char[bufferSize];
        
        // Copy input safely into buffer
        int length = Math.min(input.length(), bufferSize);
        for (int i = 0; i < length; i++) {
            buffer[i] = input.charAt(i);
        }
        
        // Convert buffer to string
        return new String(buffer, 0, length);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(handleInput("Hello", 10)); // Hello
        System.out.println(handleInput("ThisIsALongString", 8)); // ThisIsA 
        System.out.println(handleInput("", 5)); // Empty string
        System.out.println(handleInput(null, 5)); // Empty string
        System.out.println(handleInput("Test", 3)); // Tes
    }
}
