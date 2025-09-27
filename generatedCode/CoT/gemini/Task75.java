package CoT.gemini;
import java.io.IOException;

public class Task75 {

    public static void terminateProcess(int pid) throws IOException, InterruptedException {
        Process process;
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            process = Runtime.getRuntime().exec("taskkill /F /PID " + pid);
        } else {
            process = Runtime.getRuntime().exec("kill " + pid);
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Error terminating process: " + exitCode);
        }
    }


    public static void main(String[] args) {
        try {
            terminateProcess(Integer.parseInt(args[0]));
            System.out.println("Process terminated successfully.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid PID format: " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.err.println("Error terminating process: " + e.getMessage());
        }
    }
}