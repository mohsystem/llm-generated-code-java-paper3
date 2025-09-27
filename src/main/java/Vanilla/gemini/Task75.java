package Vanilla.gemini;
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
            System.err.println("Please provide PID as command line argument.");
            return;
        }

        try {
            int pid = Integer.parseInt(args[0]);
            terminateProcess(pid);


            terminateProcess(1234); // Test case 1
            terminateProcess(5678); // Test case 2
            terminateProcess(9012); // Test case 3
            terminateProcess(3456); // Test case 4
            terminateProcess(7890); // Test case 5



        } catch (NumberFormatException e) {
            System.err.println("Invalid PID format: " + args[0]);
        }
    }
}