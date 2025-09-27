package ourMethod.claude;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task54 {
    private static final int OTP_LENGTH = 6;
    private static final int OTP_VALIDITY_MINUTES = 5;
    private static final Map<String, UserAuth> userDatabase = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();
    
    static class UserAuth {
        private final String password;
        private String otp;
        private long otpGenerationTime;
        
        public UserAuth(String password) {
            this.password = password;
        }
        
        public boolean verifyPassword(String inputPassword) {
            return password != null && password.equals(inputPassword);
        }
        
        public void generateOTP() {
            StringBuilder otp = new StringBuilder();
            for (int i = 0; i < OTP_LENGTH; i++) {
                otp.append(secureRandom.nextInt(10));
            }
            this.otp = otp.toString();
            this.otpGenerationTime = System.currentTimeMillis();
        }
        
        public boolean verifyOTP(String inputOTP) {
            if (otp == null || inputOTP == null) {
                return false;
            }
            
            long currentTime = System.currentTimeMillis();
            long timeDifference = (currentTime - otpGenerationTime) / (1000 * 60);
            
            if (timeDifference > OTP_VALIDITY_MINUTES) {
                return false;
            }
            
            return otp.equals(inputOTP);
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        initializeUsers();
        
        // Test Case 1: Successful login
        System.out.println("Test Case 1: Successful login");
        loginProcess("user1", "pass1");
        
        // Test Case 2: Wrong password
        System.out.println("\\nTest Case 2: Wrong password");
        loginProcess("user1", "wrongpass");
        
        // Test Case 3: Invalid user
        System.out.println("\\nTest Case 3: Invalid user");
        loginProcess("invaliduser", "pass");
        
        // Test Case 4: Wrong OTP
        System.out.println("\\nTest Case 4: Wrong OTP");
        simulateWrongOTPLogin("user1", "pass1");
        
        // Test Case 5: OTP timeout
        System.out.println("\\nTest Case 5: OTP timeout");
        simulateOTPTimeout("user1", "pass1");
    }
    
    private static void initializeUsers() {
        userDatabase.put("user1", new UserAuth("pass1"));
        userDatabase.put("user2", new UserAuth("pass2"));
    }
    
    private static void loginProcess(String username, String password) {
        UserAuth user = userDatabase.get(username);
        
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        
        if (!user.verifyPassword(password)) {
            System.out.println("Invalid password");
            return;
        }
        
        user.generateOTP();
        System.out.println("OTP generated: " + user.otp);
        
        // Simulate OTP input
        if (user.verifyOTP(user.otp)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid OTP");
        }
    }
    
    private static void simulateWrongOTPLogin(String username, String password) {
        UserAuth user = userDatabase.get(username);
        
        if (user != null && user.verifyPassword(password)) {
            user.generateOTP();
            System.out.println("OTP generated: " + user.otp);
            
            // Simulate wrong OTP input
            if (user.verifyOTP("000000")) {
                System.out.println("Login successful");
            } else {
                System.out.println("Invalid OTP");
            }
        }
    }
    
    private static void simulateOTPTimeout(String username, String password) {
        UserAuth user = userDatabase.get(username);
        
        if (user != null && user.verifyPassword(password)) {
            user.generateOTP();
            System.out.println("OTP generated: " + user.otp);
            
            // Simulate time delay
            user.otpGenerationTime -= (OTP_VALIDITY_MINUTES + 1) * 60 * 1000;
            
            if (user.verifyOTP(user.otp)) {
                System.out.println("Login successful");
            } else {
                System.out.println("OTP expired");
            }
        }
    }
}
