package Vanilla.llama31;
import java.io.IOException;

public class Task75 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task75 <PID>");
            return;
        }
        int pid = Integer.parseInt(args[0]);
        terminateProcess(pid);
    }

    public static void terminateProcess(int pid) {
        try {
            String command = "kill " + pid;
            Process process = Runtime.getRuntime().exec(command);
            System.out.println("Process " + pid + " terminated.");
        } catch (IOException e) {
            System.out.println("Error terminating process: " + e.getMessage());
        }
    }
}