package CoT.codestral;
// Java code
import java.lang.ProcessHandle;

public class Task75 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a single process ID as argument.");
            return;
        }

        int pid;
        try {
            pid = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid process ID. Please provide a numeric value.");
            return;
        }

        terminateProcess(pid);
    }

    public static void terminateProcess(int pid) {
        ProcessHandle process = ProcessHandle.of(pid).orElse(null);
        if (process != null) {
            process.destroyForcibly();
            System.out.println("Process " + pid + " terminated.");
        } else {
            System.out.println("Process with ID " + pid + " not found.");
        }
    }
}