package CoT.claude;

public class Task45 {
    public static String processInput(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("Input cannot be null or empty");
            }
            
            // Convert to integer and perform operations
            int num = Integer.parseInt(input.trim());
            
            if (num < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }
            
            // Sample operation: Calculate square and cube
            long square = (long) num * num;
            long cube = (long) num * num * num;
            
            if (square > Integer.MAX_VALUE || cube > Integer.MAX_VALUE) {
                throw new ArithmeticException("Result too large");
            }
            
            return "Square: " + square + ", Cube: " + cube;
            
        } catch (NumberFormatException e) {
            return "Error: Input must be a valid integer";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        } catch (ArithmeticException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error: Unexpected error occurred";
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] inputs = {"10", "-5", "abc", "", "999999"};
        
        for(String input : inputs) {
            System.out.println("Input: " + input);
            System.out.println("Result: " + processInput(input));
            System.out.println();
        }
    }
}
