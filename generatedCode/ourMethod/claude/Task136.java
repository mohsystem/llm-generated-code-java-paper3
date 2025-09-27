package ourMethod.claude;

public class Task136 {
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final int MIN_PASSWORD_LENGTH = 8;
    
    private static class User {
        private String username;
        private byte[] passwordHash;
        private byte[] salt;
        private int loginAttempts;
        private boolean isLocked;
        
        public User(String username, String password) {
            this.username = username;
            this.salt = generateSalt();
            this.passwordHash = hashPassword(password, salt);
            this.loginAttempts = 0;
            this.isLocked = false;
        }
    }
    
    private static byte[] generateSalt() {
        // Generate random salt using SecureRandom
        java.security.SecureRandom random = new java.security.SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    
    private static byte[] hashPassword(String password, byte[] salt) {
        try {
            // Use PBKDF2 with SHA-256 for password hashing
            javax.crypto.spec.PBEKeySpec spec = new javax.crypto.spec.PBEKeySpec(
                password.toCharArray(), salt, 65536, 256);
            javax.crypto.SecretKeyFactory factory = javax.crypto.SecretKeyFactory
                .getInstance("PBKDF2WithHmacSHA256");
            return factory.generateSecret(spec).getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
    
    private static boolean authenticate(User user, String password) {
        if(user.isLocked) {
            System.out.println("Account is locked. Please contact administrator.");
            return false;
        }
        
        byte[] hash = hashPassword(password, user.salt);
        
        if(!java.util.Arrays.equals(hash, user.passwordHash)) {
            user.loginAttempts++;
            if(user.loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                user.isLocked = true;
                System.out.println("Account locked due to too many failed attempts");
            }
            return false;
        }
        
        // Reset login attempts on successful auth
        user.loginAttempts = 0;
        return true;
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] usernames = {"user1", "user2", "user3", "user4", "user5"};
        String[] passwords = {"Password123!", "weak", "TestPass456$", "Pass789#", "ShortPw"};
        
        for(int i = 0; i < usernames.length; i++) {
            if(passwords[i].length() < MIN_PASSWORD_LENGTH) {
                System.out.println("Password too short for " + usernames[i]);
                continue;
            }
            
            User user = new User(usernames[i], passwords[i]);
            
            // Test valid password
            System.out.println("\\nTesting " + usernames[i]);
            System.out.println("Valid password: " + authenticate(user, passwords[i]));
            
            // Test invalid password
            System.out.println("Invalid password: " + authenticate(user, "wrongpass"));
            
            // Test account lockout
            for(int j = 0; j < MAX_LOGIN_ATTEMPTS; j++) {
                authenticate(user, "wrongpass");
            }
            
            // Test after lockout
            System.out.println("After lockout: " + authenticate(user, passwords[i]));
        }
    }
}
