package ourMethod.codestral;
import java.lang.ProcessBuilder;
import java.lang.Process;
import java.lang.Runtime;
import java.lang.Exception;

public class Task75 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No process ID provided.");
            return;
        }

        try {
            int pid = Integer.parseInt(args[0]);
            Process process = Runtime.getRuntime().exec("kill " + pid);
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Process " + pid + " terminated successfully.");
            } else {
                System.out.println("Failed to terminate process " + pid + ".");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid process ID provided.");
        } catch (Exception e) {
            System.out.println("An error occurred while terminating the process.");
        }
    }
}