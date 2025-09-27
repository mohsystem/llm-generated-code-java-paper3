package Vanilla.llama31;
public class Task45 {
    public static void main(String[] args) {
        // Test cases
        testCases();
    }

    public static void testCases() {
        String[] inputs = {"10", "20", "abc", "30.5", "40"};
        for (String input : inputs) {
            try {
                int number = Integer.parseInt(input);
                System.out.println("Input: " + input + ", Result: " + (number * 2));
            } catch (NumberFormatException e) {
                try {
                    double number = Double.parseDouble(input);
                    System.out.println("Input: " + input + ", Result: " + (number * 2));
                } catch (NumberFormatException ex) {
                    System.out.println("Input: " + input + ", Error: Invalid input");
                }
            }
        }
    }
}