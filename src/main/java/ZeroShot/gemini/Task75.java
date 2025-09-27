package ZeroShot.gemini;
class Task75 {
    public static void terminateProcess(int pid) {
        try {
            Process process = Runtime.getRuntime().exec("taskkill /F /PID " + pid);
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Process with PID " + pid + " terminated successfully.");
            } else {
                System.err.println("Failed to terminate process with PID " + pid + ". Exit code: " + exitCode);
            }
        } catch (Exception e) {
            System.err.println("Error terminating process: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please provide a process ID as a command-line argument.");
            return;
        }

        try {
            int pid = Integer.parseInt(args[0]);
            terminateProcess(pid);
            
            // Test cases (replace with actual PIDs):
            terminateProcess(1234);
            terminateProcess(5678);
            terminateProcess(9012);
            terminateProcess(3456);
            terminateProcess(7890);

        } catch (NumberFormatException e) {
            System.err.println("Invalid process ID: " + args[0]);
        }
    }
}