package CoT.claude;

public class Task71 {
    public static Integer convertStringToInt(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {"123", "-456", "abc", "12.34", ""};
        
        for (String input : testInputs) {
            Integer result = convertStringToInt(input);
            if (result != null) {
                System.out.println("Input: " + input + " -> Converted to: " + result);
            } else {
                System.out.println("Input: " + input + " -> Invalid integer");
            }
        }
        
        // Command line argument check
        if (args.length > 0) {
            Integer result = convertStringToInt(args[0]);
            if (result != null) {
                System.out.println("Command line input: " + args[0] + " -> Converted to: " + result);
            } else {
                System.out.println("Command line input: " + args[0] + " -> Invalid integer");
            }
        }
    }
}
