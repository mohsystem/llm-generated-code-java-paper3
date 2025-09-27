package ourMethod.llama31;
public class Task71 {
    public static void main(String[] args) {
        String[] testCases = {"123", "abc", "123.45", "-123"};
        for (String testCase : testCases) {
            try {
                int num = Integer.parseInt(testCase);
                System.out.println("Converted integer: " + num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Cannot convert to integer.");
            }
        }
    }
}