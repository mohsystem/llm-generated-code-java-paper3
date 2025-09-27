package CoT.llama31;
public class Task98 {
    public static void main(String[] args) {
        testCases();
    }

    public static void testCases() {
        String[] inputs = {"123", "abc", "123.45", "-123", "0"};
        for (String input : inputs) {
            try {
                int result = convertToInt(input);
                System.out.println("Input: " + input + ", Output: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Input: " + input + ", Output: Not an integer");
            }
        }
    }

    public static int convertToInt(String input) {
        return Integer.parseInt(input);
    }
}