package CoT.openai;
import java.io.IOException;

public class Task75 {

    public static void terminateProcess(int pid) throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        Process process;
        if (os.contains("win")) {
            process = Runtime.getRuntime().exec("taskkill /PID " + pid);
        } else {
            process = Runtime.getRuntime().exec("kill -9 " + pid);
        }
        process.waitFor();
    }

    public static void main(String[] args) {
        int[] testPids = {1234, 5678, 9101, 1121, 3141}; // Replace with actual PIDs to test
        for (int pid : testPids) {
            try {
                terminateProcess(pid);
                System.out.println("Terminated process with PID: " + pid);
            } catch (IOException | InterruptedException e) {
                System.out.println("Failed to terminate process with PID: " + pid);
            }
        }
    }
}