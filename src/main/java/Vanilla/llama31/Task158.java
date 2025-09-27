package Vanilla.llama31;
public class Task158 {
    public static void main(String[] args) {
        // Test cases
        String[] commands = {"ls -l", "echo Hello World!", "pwd", "cat /etc/hosts", "date"};

        for (String command : commands) {
            System.out.println("Executing command: " + command);
            try {
                Process process = Runtime.getRuntime().exec(command);
                process.waitFor();
            } catch (Exception e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
        }

        // User input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a command: ");
        String userInput = scanner.nextLine();
        System.out.println("Executing command: " + userInput);
        try {
            Process process = Runtime.getRuntime().exec(userInput);
            process.waitFor();
        } catch (Exception e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }
}