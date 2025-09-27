package Vanilla.claude;

public class Task71 {
    public static Integer convertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {"123", "-456", "0", "abc", "12.34"};
        
        for(String input : testInputs) {
            Integer result = convertToInt(input);
            if(result != null) {
                System.out.println("Input: " + input + " -> Successfully converted to: " + result);
            } else {
                System.out.println("Input: " + input + " -> Conversion failed");
            }
        }
    }
}
