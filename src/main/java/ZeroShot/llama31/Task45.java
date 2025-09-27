package ZeroShot.llama31;
public class Task45 {
    public static void main(String[] args) {
        testCases();
    }

    public static void testCases() {
        String[] inputs = {"10", "abc", "20", "-5", "30"};
        for (String input : inputs) {
            try {
                int number = Integer.parseInt(input);
                System.out.println("Input: " + number + ", Result: " + processInput(number));
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input - " + input);
            }
        }
    }

    public static int processInput(int number) {
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Negative number");
            }
            return number * 2;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}