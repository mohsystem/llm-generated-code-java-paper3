package ourMethod.gpt4o;
import java.util.Arrays;

public class Task75 {
    public static void main(String[] args) {
        int[] testPIDs = {1234, 5678, 91011, 1213, 1415};
        for (int pid : testPIDs) {
            boolean result = terminateProcess(pid);
            System.out.println("Terminating PID " + pid + ": " + (result ? "Success" : "Failed"));
        }
    }

    public static boolean terminateProcess(int pid) {
        if (pid <= 0) return false; // Invalid PID
        try {
            ProcessBuilder pb = new ProcessBuilder("kill", String.valueOf(pid));
            Process process = pb.start();
            process.waitFor();
            return process.exitValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }
}