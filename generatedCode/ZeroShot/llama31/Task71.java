package ZeroShot.llama31;
public class Task71 {
    public static void main(String[] args) {
        String[] testCases = {"123", "456", "abc", "789", "123.45"};
        for (String testCase : testCases) {
            try {
                int number = convertStringToInt(testCase);
                System.out.println("Converted integer: " + number);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int convertStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid input. Please enter a valid integer string.");
        }
    }
}