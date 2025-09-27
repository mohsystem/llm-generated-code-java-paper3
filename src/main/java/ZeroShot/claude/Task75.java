package ZeroShot.claude;

import java.io.IOException;

public class Task75 {
    public static boolean terminateProcess(int pid) {
        try {
            Process process = Runtime.getRuntime().exec("taskkill /F /PID " + pid);
            process.waitFor();
            return process.exitValue() == 0;
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
