package ZeroShot.gpt4o;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.io.IOException;

public class Task75 {
    public static boolean terminateProcess(int pid) {
        if (pid <= 0) {
            return false;
        }
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String command;
            if (os.contains("win")) {
                command = "taskkill /PID " + pid + " /F";
            } else {
                command = "kill -9 " + pid;
            }
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            return process.exitValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] testPIDs = {1234, 5678, 9101, 1121, 3141};
        for (int pid : testPIDs) {
            boolean result = terminateProcess(pid);
            System.out.println("Terminate process " + pid + ": " + result);
        }
    }
}