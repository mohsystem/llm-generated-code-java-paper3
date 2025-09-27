package CoT.claude;

import java.io.IOException;

public class Task75 {
    public static boolean terminateProcess(int pid) {
        if (pid <= 0) {
            return false;
        }
        
        try {
            Process process = Runtime.getRuntime().exec("taskkill /F /PID " + pid);
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] testPids = {1234, 5678, 9012, 3456, 7890};
        
        for(int pid : testPids) {
            System.out.println("Attempting to terminate process with PID: " + pid);
            boolean result = terminateProcess(pid);
            System.out.println("Process termination " + (result ? "successful" : "failed"));
        }
    }
}
