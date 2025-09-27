package ZeroShot.llama31;
import java.io.IOException;

public class Task75 {
    public static void main(String[] args) {
        // Test cases
        int[] pids = {1234, 5678, 9012, 1111, 2222};
        for (int pid : pids) {
            terminateProcess(pid);
        }
    }

    public static void terminateProcess(int pid) {
        try {
            String command = "kill " + pid;
            if (System.getProperty("os.name").startsWith("Windows")) {
                command = "taskkill /F /PID " + pid;
            }
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("Process " + pid + " terminated.");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error terminating process: " + e.getMessage());
        }
    }
}