package CoT.claude;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Task54 {
    private static Map<String, String> userCredentials = new HashMap<>();
    private static Map<String, String> otpStore = new HashMap<>();
    private static final int OTP_LENGTH = 6;
    private static final int OTP_VALIDITY_MINUTES = 5;
    
    // Generate secure OTP
    private static String generateOTP() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder otp = new StringBuilder();
        for(int i = 0; i < OTP_LENGTH; i++) {
            otp.append(secureRandom.nextInt(10));
        }
        return otp.toString();
    }
    
    // Register new user
    public static boolean registerUser(String username, String password) {
        if(username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }
        if(userCredentials.containsKey(username)) {
            return false;
        }
        userCredentials.put(username, password);
        return true;
    }
    
    // First factor authentication
    public static boolean validateFirstFactor(String username, String password) {
        if(username == null || password == null) {
            return false;
        }
        String storedPassword = userCredentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
    
    // Generate and store OTP for user
    public static String generateAndStoreOTP(String username) {
        if(!userCredentials.containsKey(username)) {
            return null;
        }
        String otp = generateOTP();
        otpStore.put(username, otp);
        return otp;
    }
    
    // Validate OTP (second factor)
    public static boolean validateOTP(String username, String otp) {
        if(username == null || otp == null) {
            return false;
        }
        String storedOTP = otpStore.get(username);
        if(storedOTP != null && storedOTP.equals(otp)) {
            otpStore.remove(username); // One-time use only
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // Test Case 1: Successful registration and authentication
        System.out.println("Test Case 1:");
        registerUser("user1", "pass123");
        boolean firstAuth = validateFirstFactor("user1", "pass123");
        String otp = generateAndStoreOTP("user1");
        System.out.println("First factor auth: " + firstAuth);
        System.out.println("OTP generated: " + otp);
        System.out.println("OTP validation: " + validateOTP("user1", otp));
        
        // Test Case 2: Wrong password
        System.out.println("\\nTest Case 2:");
        System.out.println("Wrong password auth: " + validateFirstFactor("user1", "wrongpass"));
        
        // Test Case 3: Wrong OTP
        System.out.println("\\nTest Case 3:");
        otp = generateAndStoreOTP("user1");
        System.out.println("Wrong OTP validation: " + validateOTP("user1", "000000"));
        
        // Test Case 4: Non-existent user
        System.out.println("\\nTest Case 4:");
        System.out.println("Non-existent user auth: " + validateFirstFactor("user2", "pass123"));
        
        // Test Case 5: Reuse of OTP
        System.out.println("\\nTest Case 5:");
        otp = generateAndStoreOTP("user1");
        System.out.println("First OTP validation: " + validateOTP("user1", otp));
        System.out.println("Reused OTP validation: " + validateOTP("user1", otp));
    }
}
