package ourMethod.codestral;
public class Task71 {
    public static Integer convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return null;
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Integer result = convertToInteger(args[0]);
            if (result != null) {
                System.out.println("Converted integer: " + result);
            }
        } else {
            System.out.println("Please provide a string input as a command line argument.");
        }
    }
}