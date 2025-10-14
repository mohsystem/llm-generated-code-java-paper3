package ZeroShot.openai;
import java.util.ArrayList;
import java.util.List;

public class Task132 {
    private List<String> logs;

    public Task132() {
        logs = new ArrayList<>();
    }

    public void logEvent(String event) {
        if (event != null && !event.trim().isEmpty()) {
            logs.add(event);
        }
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }

    public static void main(String[] args) {
        Task132 securityLogger = new Task132();
        securityLogger.logEvent("User login attempt");
        securityLogger.logEvent("File accessed");
        securityLogger.logEvent("Unauthorized access detected");
        securityLogger.logEvent("Password change request");
        securityLogger.logEvent("System settings modified");

        List<String> logs = securityLogger.getLogs();
        for (String log : logs) {
            System.out.println(log);
        }
    }
}