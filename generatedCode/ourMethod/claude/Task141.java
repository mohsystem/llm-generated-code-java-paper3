package ourMethod.claude;

public class Task141 {
    public static String reverseString(String input) {
        // Input validation
        if (input == null) {
            return null;
        }
        
        // Convert string to char array for more efficient reversal
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        // Reverse by swapping characters from start and end
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right]; 
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "hello",
            "",
            "a",
            "12345",
            "Hello World!"
        };
        
        for (String test : tests) {
            System.out.println("Input: \\"" + test + "\\"");
            System.out.println("Output: \\"" + reverseString(test) + "\\"");
            System.out.println();
        }
    }
}
