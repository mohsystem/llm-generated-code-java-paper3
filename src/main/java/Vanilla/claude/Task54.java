package Vanilla.claude;

import java.util.HashMap;
import java.util.Random;

public class Task54 {
    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, String> otpMap = new HashMap<>();
    
    public static String generateOTP(String username) {
        Random random = new Random();
        String otp = String.format("%06d", random.nextInt(1000000));
        otpMap.put(username, otp);
        return otp;
    }
    
    public static boolean validateOTP(String username, String otp) {
        String storedOTP = otpMap.get(username);
        if(storedOTP != null && storedOTP.equals(otp)) {
            otpMap.remove(username); // One time use only
            return true;
        }
        return false;
    }
    
    public static boolean register(String username, String password) {
        if(!users.containsKey(username)) {
            users.put(username, password);
            return true;
        }
        return false;
    }
    
    public static boolean login(String username, String password, String otp) {
        String storedPassword = users.get(username);
        if(storedPassword != null && storedPassword.equals(password)) {
            return validateOTP(username, otp);
        }
        return false;
    }
    
    public static void main(String[] args) {
        // Test case 1: Successful registration and login
        register("user1", "pass123");
        String otp1 = generateOTP("user1");
        System.out.println("Test 1: " + login("user1", "pass123", otp1));
        
        // Test case 2: Wrong password
        register("user2", "pass456");
        String otp2 = generateOTP("user2");
        System.out.println("Test 2: " + login("user2", "wrongpass", otp2));
        
        // Test case 3: Wrong OTP
        register("user3", "pass789");
        generateOTP("user3");
        System.out.println("Test 3: " + login("user3", "pass789", "000000"));
        
        // Test case 4: Reusing OTP
        register("user4", "pass321");
        String otp4 = generateOTP("user4");
        login("user4", "pass321", otp4);
        System.out.println("Test 4: " + login("user4", "pass321", otp4));
        
        // Test case 5: Non-existent user
        String otp5 = generateOTP("user5");
        System.out.println("Test 5: " + login("user5", "pass999", otp5));
    }
}
