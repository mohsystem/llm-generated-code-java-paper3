package Vanilla.codestral;
// Java code
public class Task75 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide exactly one argument: the PID.");
            return;
        }
        int pid = Integer.parseInt(args[0]);
        terminateProcess(pid);
    }

    public static void terminateProcess(int pid) {
        try {
            Process process = Runtime.getRuntime().exec("kill " + pid);
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Process successfully terminated.");
            } else {
                System.out.println("Could not terminate process.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while trying to terminate process: " + e.getMessage());
        }
    }
}