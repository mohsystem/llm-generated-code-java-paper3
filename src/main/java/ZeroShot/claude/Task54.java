package ZeroShot.claude;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Scanner;

public class Task54 {
    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, String> otpStore = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();
    
    public static String generateOTP() {
        StringBuilder otp = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            otp.append(secureRandom.nextInt(10));
        }
        return otp.toString();
    }
    
    public static boolean registerUser(String username, String password) {
        if(!users.containsKey(username)) {
            users.put(username, password);
            return true;
        }
        return false;
    }
    
    public static boolean login(String username, String password, String otp) {
        if(users.containsKey(username) && users.get(username).equals(password)) {
            if(otpStore.containsKey(username) && otpStore.get(username).equals(otp)) {
                otpStore.remove(username); // OTP can be used only once
                return true;
            }
        }
        return false;
    }
    
    public static String sendOTP(String username) {
        if(users.containsKey(username)) {
            String otp = generateOTP();
            otpStore.put(username, otp);
            return otp;
        }
        return null;
    }

    public static void main(String[] args) {
        // Test Case 1: Successful registration
        System.out.println("Test 1: " + registerUser("user1", "pass123"));
        
        // Test Case 2: Registration with existing username
        System.out.println("Test 2: " + registerUser("user1", "pass456"));
        
        // Test Case 3: Generate and verify OTP
        String otp = sendOTP("user1");
        System.out.println("Test 3: " + login("user1", "pass123", otp));
        
        // Test Case 4: Login with wrong OTP
        System.out.println("Test 4: " + login("user1", "pass123", "000000"));
        
        // Test Case 5: Login with expired/used OTP
        System.out.println("Test 5: " + login("user1", "pass123", otp));
    }
}
