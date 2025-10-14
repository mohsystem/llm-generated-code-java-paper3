package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;

class Task132 {
    private List<String> securityEvents;

    public Task132() {
        securityEvents = new ArrayList<>();
    }

    public void logEvent(String event) {
        if (event != null && !event.isEmpty()) {
            securityEvents.add(event);
        }
    }

    public List<String> getLoggedEvents() {
        return new ArrayList<>(securityEvents);
    }

    public static void main(String[] args) {
        Task132 monitor = new Task132();
        monitor.logEvent("User login from IP 192.168.1.1");
        monitor.logEvent("Failed login attempt for user admin");
        monitor.logEvent("User logout from IP 192.168.1.1");
        monitor.logEvent("Password change for user guest");
        monitor.logEvent("User login from IP 10.0.0.2");

        for (String event : monitor.getLoggedEvents()) {
            System.out.println(event);
        }
    }
}