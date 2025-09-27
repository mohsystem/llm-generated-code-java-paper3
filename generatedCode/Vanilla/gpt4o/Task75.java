package Vanilla.gpt4o;
import java.lang.management.ManagementFactory;
import java.lang.ProcessBuilder;
import java.io.IOException;

public class Task75 {
    public static void terminateProcessJava(int pid) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;
            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("taskkill", "/F", "/PID", String.valueOf(pid));
            } else {
                processBuilder = new ProcessBuilder("kill", "-9", String.valueOf(pid));
            }
            processBuilder.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Test cases
        terminateProcessJava(1234);
        terminateProcessJava(5678);
        terminateProcessJava(9101);
        terminateProcessJava(1121);
        terminateProcessJava(3141);
    }
}