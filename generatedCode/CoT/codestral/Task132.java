package CoT.codestral;
import java.util.logging.Logger;

public class Task132 {
    private static final Logger LOGGER = Logger.getLogger(Task132.class.getName());

    public static void logSecurityEvent(String event) {
        LOGGER.info("Security event: " + event);
    }

    public static void main(String[] args) {
        logSecurityEvent("Unauthorized access attempt");
        logSecurityEvent("Suspicious network activity");
        // add more test cases as needed
    }
}