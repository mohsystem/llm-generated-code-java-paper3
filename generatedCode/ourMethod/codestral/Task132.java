package ourMethod.codestral;
import java.util.logging.Logger;

public class SecurityEventLogger {
    private static final Logger logger = Logger.getLogger(SecurityEventLogger.class.getName());

    public void logEvent(String event) {
        if (event == null || event.isEmpty()) {
            throw new IllegalArgumentException("Event cannot be null or empty");
        }
        logger.info("Security Event: " + event);
    }

    public void monitorEvents() {
        // Add your monitoring logic here
    }

    public static void main(String[] args) {
        SecurityEventLogger logger = new SecurityEventLogger();
        logger.logEvent("User login attempt");
        logger.logEvent("Unauthorized access attempt");
        logger.logEvent("Password change");
    }
}