package CoT.claude;

public class Task136 {
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final int MIN_PASSWORD_LENGTH = 8;
    
    private static class User {
        private String username;
        private String passwordHash;
        private int loginAttempts;
        private boolean isLocked;
        
        public User(String username, String password) {
            this.username = username;
            this.passwordHash = hashPassword(password);
            this.loginAttempts = 0;
            this.isLocked = false;
        }
    }
    
    private static String hashPassword(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static boolean authenticate(User user, String password) {
        if(user == null || password == null || password.isEmpty()) {
            return false;
        }
        
        if(user.isLocked) {
            System.out.println("Account is locked. Please contact admin.");
            return false;
        }
        
        if(user.passwordHash.equals(hashPassword(password))) {
            user.loginAttempts = 0;
            return true;
        } else {
            user.loginAttempts++;
            if(user.loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                user.isLocked = true;
                System.out.println("Account locked due to too many failed attempts");
            }
            return false;
        }
    }
    
    public static boolean validatePassword(String password) {
        if(password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for(char c : password.toCharArray()) {
            if(Character.isUpperCase(c)) hasUpper = true;
            if(Character.isLowerCase(c)) hasLower = true;
            if(Character.isDigit(c)) hasDigit = true;
        }
        return hasUpper && hasLower && hasDigit;
    }
    
    public static void main(String[] args) {
        // Test cases
        User user = new User("testUser", "SecurePass123");
        
        // Test 1: Correct password
        System.out.println("Test 1: " + authenticate(user, "SecurePass123")); // Should print true
        
        // Test 2: Wrong password
        System.out.println("Test 2: " + authenticate(user, "wrongpass")); // Should print false
        
        // Test 3: Password validation
        System.out.println("Test 3: " + validatePassword("Weak")); // Should print false
        System.out.println("Test 4: " + validatePassword("StrongPass123")); // Should print true
        
        // Test 5: Account lockout
        authenticate(user, "wrong1");
        authenticate(user, "wrong2");
        authenticate(user, "wrong3");
        System.out.println("Test 5: " + authenticate(user, "SecurePass123")); // Should print false (account locked)
    }
}
