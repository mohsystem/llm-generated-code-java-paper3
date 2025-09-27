package ourMethod.claude;

import java.io.IOException;

public class Task75 {
    public static boolean terminateProcess(int pid) {
        if (pid <= 0) {
            System.err.println("Invalid PID provided");
            return false;
        }
        
        try {
            //todo incompatible types: no instance(s) of type variable(s) X exist so that ProcessHandle conforms to Process
            //where X,T are type-variables:
            //X extends Throwable declared in method <X>orElseThrow(Supplier<? extends X>)
            //T extends Object declared in class Optional
            //Process process = ProcessHandle.of(pid)
            ProcessHandle process = ProcessHandle.of(pid)
                .orElseThrow(() -> new IllegalArgumentException("Process not found"));
            return process.destroy();
        } catch (Exception e) {
            System.err.println("Error terminating process: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Task75 <pid>");
            System.exit(1);
        }

        try {
            int pid = Integer.parseInt(args[0]);
            boolean success = terminateProcess(pid);
            System.out.println(success ? "Process terminated successfully" : "Failed to terminate process");
        } catch (NumberFormatException e) {
            System.err.println("Invalid PID format. Please provide a valid number");
            System.exit(1);
        }
    }
}
