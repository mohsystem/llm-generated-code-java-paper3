package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task75 {
    public static void terminateProcess(int pid) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            List<String> command = new ArrayList<>();

            if (os.contains("win")) {
                command.add("taskkill");
                command.add("/PID");
                command.add(String.valueOf(pid));
            } else {
                command.add("kill");
                command.add("-9");
                command.add(String.valueOf(pid));
            }

            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Test cases
        terminateProcess(1234);
        terminateProcess(5678);
        terminateProcess(91011);
        terminateProcess(1213);
        terminateProcess(1415);
    }
}