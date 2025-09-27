package ourMethod.gpt4o;
import java.util.ArrayList;
import java.util.List;

class Task132 {

    private List<String> securityLog = new ArrayList<>();

    public void logEvent(String event) {
        if (event == null || event.isEmpty()) {
            throw new IllegalArgumentException("Event description cannot be null or empty.");
        }
        securityLog.add(event);
        System.out.println("Event logged: " + event);
    }

    public List<String> getSecurityLog() {
        return new ArrayList<>(securityLog);
    }

    public static void main(String[] args) {
        Task132 task = new Task132();
        task.logEvent("User login from unknown IP.");
        task.logEvent("Failed login attempt.");
        task.logEvent("Suspicious file download detected.");
        task.logEvent("Unauthorized access attempt.");
        task.logEvent("Security policy update.");
        
        System.out.println("Security Log: " + task.getSecurityLog());
    }
}