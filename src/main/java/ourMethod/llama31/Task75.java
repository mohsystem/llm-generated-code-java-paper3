package ourMethod.llama31;
import java.lang.ProcessBuilder;
import java.lang.Process;

public class Task75 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task75 <PID>");
            return;
        }

        try {
            int pid = Integer.parseInt(args[0]);
            Process process = Runtime.getRuntime().exec("kill " + pid);
            int exitValue = process.waitFor();
            if (exitValue == 0) {
                System.out.println("Process " + pid + " terminated successfully.");
            } else {
                System.out.println("Failed to terminate process " + pid + ". Exit value: " + exitValue);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}