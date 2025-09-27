package ZeroShot.llama31;
import java.util.Scanner;
import java.io.IOException;

public class Task158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] allowedCommands = {"ls", "pwd", "date"};

        while (true) {
            System.out.print("Enter a command (ls, pwd, date) or 'exit' to quit: ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            boolean isValid = false;
            for (String allowedCommand : allowedCommands) {
                if (command.equals(allowedCommand)) {
                    isValid = true;
                    break;
                }
            }

            if (isValid) {
                try {
                    Process process = Runtime.getRuntime().exec(command);
                    process.waitFor();
                    printOutput(process);
                } catch (IOException | InterruptedException e) {
                    System.err.println("Error executing command: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid command. Please use one of the following: ls, pwd, date");
            }
        }
    }

    private static void printOutput(Process process) throws IOException {
        java.util.Scanner s = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
        System.out.println(s.hasNext() ? s.next() : "");
    }
}