package ourMethod.gemini;
import java.io.IOException;
import java.lang.reflect.Field;

public class Task75 {

    public static void terminateProcess(int pid) throws IOException {
        try {
            Process process;
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                process = Runtime.getRuntime().exec("taskkill /F /PID " + pid);
            } else {  // Assume Unix-like for simplicity
                process = Runtime.getRuntime().exec("kill " + pid);
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new IOException("Process termination failed with exit code: " + exitCode);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Process termination interrupted", e);
        }
    }

    public static void main(String[] args) throws IOException {
       if (args.length == 0) {
            System.out.println("Please provide PID as command line argument");
            return;
        }
         try {
            int pid = Integer.parseInt(args[0]);
            terminateProcess(pid);
            System.out.println("Process with PID " + pid + " terminated.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid PID format. Please provide an integer.");
        }
    }
}