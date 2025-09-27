package ourMethod.claude;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;
import java.util.regex.Pattern;

public class Task132 {
    private static final Logger logger;
    private static final String LOG_FILE = "security_events.log";
    private static final Pattern VALID_MESSAGE_PATTERN = Pattern.compile("^[\\\\w\\\\s\\\\-.,!?()]+$");
    
    static {
        logger = Logger.getLogger(Task132.class.getName());
        try {
            // Set up secure file handler with proper permissions
            FileHandler fileHandler = new FileHandler(LOG_FILE, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
            
            // Set restrictive file permissions
            File logFile = new File(LOG_FILE);
            logFile.setReadable(true, true);  // Readable only by owner
            logFile.setWritable(true, true);  // Writable only by owner
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void logSecurityEvent(String message, Level severity) {
        if (message == null || severity == null) {
            throw new IllegalArgumentException("Message and severity cannot be null");
        }

        // Validate message format to prevent log injection
        if (!isValidMessage(message)) {
            throw new IllegalArgumentException("Invalid message format");
        }

        // Sanitize message by removing sensitive patterns
        String sanitizedMessage = sanitizeMessage(message);

        try {
            // Create structured log entry
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String logEntry = String.format("[%s] [%s] %s", timestamp, severity.getName(), sanitizedMessage);
            
            logger.log(severity, logEntry);
        } catch (SecurityException e) {
            System.err.println("Security error while logging: " + e.getMessage());
            throw e;
        }
    }

    private static boolean isValidMessage(String message) {
        return VALID_MESSAGE_PATTERN.matcher(message).matches();
    }

    private static String sanitizeMessage(String message) {
        // Remove potential sensitive data patterns
        message = message.replaceAll("\\\\b\\\\d{16}\\\\b", "****"); // Credit card numbers
        message = message.replaceAll("\\\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}\\\\b", "[EMAIL]"); // Email addresses
        message = message.replaceAll("\\\\b\\\\d{3}-\\\\d{2}-\\\\d{4}\\\\b", "***-**-****"); // SSN
        return message;
    }

    public static void main(String[] args) {
        // Test cases
        try {
            logSecurityEvent("User login attempt from IP 192.168.1.1", Level.INFO);
            logSecurityEvent("Failed password attempt for user john@example.com", Level.WARNING);
            logSecurityEvent("Successful authentication for user ID 12345", Level.INFO);
            logSecurityEvent("Security policy updated by admin", Level.INFO);
            logSecurityEvent("Multiple failed login attempts detected", Level.SEVERE);
        } catch (Exception e) {
            System.err.println("Error in main: " + e.getMessage());
        }
    }
}
