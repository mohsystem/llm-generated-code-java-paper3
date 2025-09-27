package CoT.llama31;
public class Task75 {
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {"1234", "5678", "9012"};
        for (String testCase : testCases) {
            try {
                Process process = Runtime.getRuntime().exec("kill " + testCase);
                process.waitFor();
                System.out.println("Process " + testCase + " terminated.");
            } catch (Exception e) {
                System.out.println("Error terminating process: " + e.getMessage());
            }
        }
    }
}