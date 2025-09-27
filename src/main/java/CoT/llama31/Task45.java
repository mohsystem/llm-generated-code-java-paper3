package CoT.llama31;
public class Task45 {
    public static void main(String[] args) {
        // Test cases
        handleUserInput("10");
        handleUserInput("abc");
        handleUserInput("5.5");
        handleUserInput("");
        handleUserInput(null);
    }

    public static void handleUserInput(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Input is an integer: " + number);
            performOperations(number);
        } catch (NumberFormatException e) {
            System.out.println("Input is not an integer.");
        } catch (NullPointerException e) {
            System.out.println("Input is null.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void performOperations(int number) {
        try {
            int result = number * 2;
            System.out.println("Result of operation: " + result);
        } catch (Exception e) {
            System.out.println("An error occurred during operation: " + e.getMessage());
        }
    }
}