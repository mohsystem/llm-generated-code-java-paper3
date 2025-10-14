package ourMethod.claude;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.time.Instant;

public class Task123 {
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 128;
    private static final int SESSION_TIMEOUT_SECONDS = 3600;
    private static final SecureRandom secureRandom = new SecureRandom();
    
    private final Map<String, SessionData> sessions = new ConcurrentHashMap<>();
    private final SecretKey encryptionKey;
    
    private static class SessionData {
        final String userId;
        final long createdAt;
        final long expiresAt;
        final byte[] encryptedData;
        
        SessionData(String userId, long createdAt, long expiresAt, byte[] encryptedData) {
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("User ID cannot be null or empty");
            }
            if (createdAt <= 0 || expiresAt <= 0 || expiresAt <= createdAt) {
                throw new IllegalArgumentException("Invalid timestamps");
            }
            if (encryptedData == null || encryptedData.length == 0) {
                throw new IllegalArgumentException("Encrypted data cannot be null or empty");
            }
            this.userId = userId;
            this.createdAt = createdAt;
            this.expiresAt = expiresAt;
            this.encryptedData = encryptedData.clone();
        }
    }
    
    public Task123(String masterPassword) throws Exception {
        if (masterPassword == null || masterPassword.length() < 8) {
            throw new IllegalArgumentException("Master password must be at least 8 characters");
        }
        this.encryptionKey = deriveKey(masterPassword);
    }
    
    private SecretKey deriveKey(String password) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(hash, "AES");
    }
    
    public String createSession(String userId, String sessionData) throws Exception {
        if (userId == null || userId.isEmpty() || userId.length() > 256) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        if (sessionData == null || sessionData.isEmpty() || sessionData.length() > 10000) {
            throw new IllegalArgumentException("Invalid session data");
        }
        
        long now = Instant.now().getEpochSecond();
        long expiresAt = now + SESSION_TIMEOUT_SECONDS;
        
        byte[] encryptedData = encryptAES(sessionData.getBytes(StandardCharsets.UTF_8));
        
        byte[] sessionIdBytes = new byte[32];
        secureRandom.nextBytes(sessionIdBytes);
        String sessionId = Base64.getUrlEncoder().withoutPadding().encodeToString(sessionIdBytes);
        
        SessionData session = new SessionData(userId, now, expiresAt, encryptedData);
        sessions.put(sessionId, session);
        
        return sessionId;
    }
    
    public String validateSession(String sessionId) throws Exception {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        
        SessionData session = sessions.get(sessionId);
        if (session == null) {
            return null;
        }
        
        long now = Instant.now().getEpochSecond();
        if (now > session.expiresAt) {
            sessions.remove(sessionId);
            return null;
        }
        
        return session.userId;
    }
    
    public String getSessionData(String sessionId) throws Exception {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        
        SessionData session = sessions.get(sessionId);
        if (session == null) {
            return null;
        }
        
        long now = Instant.now().getEpochSecond();
        if (now > session.expiresAt) {
            sessions.remove(sessionId);
            return null;
        }
        
        byte[] decryptedData = decryptAES(session.encryptedData);
        return new String(decryptedData, StandardCharsets.UTF_8);
    }
    
    public boolean destroySession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            return false;
        }
        return sessions.remove(sessionId) != null;
    }
    
    private byte[] encryptAES(byte[] plaintext) throws Exception {
        byte[] iv = new byte[GCM_IV_LENGTH];
        secureRandom.nextBytes(iv);
        
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, encryptionKey, spec);
        
        byte[] ciphertext = cipher.doFinal(plaintext);
        
        ByteBuffer buffer = ByteBuffer.allocate(iv.length + ciphertext.length);
        buffer.put(iv);
        buffer.put(ciphertext);
        
        return buffer.array();
    }
    
    private byte[] decryptAES(byte[] encryptedData) throws Exception {
        if (encryptedData.length < GCM_IV_LENGTH + 16) {
            throw new IllegalArgumentException("Invalid encrypted data length");
        }
        
        ByteBuffer buffer = ByteBuffer.wrap(encryptedData);
        byte[] iv = new byte[GCM_IV_LENGTH];
        buffer.get(iv);
        byte[] ciphertext = new byte[buffer.remaining()];
        buffer.get(ciphertext);
        
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, encryptionKey, spec);
        
        return cipher.doFinal(ciphertext);
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("Test 1: Create and validate session");
            Task123 manager = new Task123("SecurePass123!");
            String sessionId = manager.createSession("user001", "User session data");
            String userId = manager.validateSession(sessionId);
            System.out.println("Session valid: " + (userId != null && userId.equals("user001")));
            
            System.out.println("\\nTest 2: Retrieve session data");
            String data = manager.getSessionData(sessionId);
            System.out.println("Data retrieved: " + (data != null && data.equals("User session data")));
            
            System.out.println("\\nTest 3: Destroy session");
            boolean destroyed = manager.destroySession(sessionId);
            System.out.println("Session destroyed: " + destroyed);
            String invalidUserId = manager.validateSession(sessionId);
            System.out.println("Session invalid after destroy: " + (invalidUserId == null));
            
            System.out.println("\\nTest 4: Multiple sessions");
            String sid1 = manager.createSession("user001", "Session 1");
            String sid2 = manager.createSession("user002", "Session 2");
            System.out.println("Multiple sessions created: " + (!sid1.equals(sid2)));
            
            System.out.println("\\nTest 5: Invalid input handling");
            try {
                manager.createSession(null, "data");
                System.out.println("Null user ID rejected: false");
            } catch (IllegalArgumentException e) {
                System.out.println("Null user ID rejected: true");
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
