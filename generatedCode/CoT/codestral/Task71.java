package CoT.codestral;
public class Task71 {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int num = Integer.parseInt(args[0]);
                System.out.println("Converted integer: " + num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } else {
            System.out.println("Please provide a string input as a command line argument.");
        }
    }

    public static Integer stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}