package ourMethod.claude;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;
import java.util.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Task134 {
    private static final int KEY_SIZE = 256;
    private Map<String, KeyEntry> keyStore;
    private final SecureRandom secureRandom;
    
    private static class KeyEntry {
        final SecretKey key;
        final Instant creationTime;
        final Instant expirationTime;
        
        KeyEntry(SecretKey key, Instant creationTime, Instant expirationTime) {
            this.key = key;
            this.creationTime = creationTime;
            this.expirationTime = expirationTime;
        }
    }
    
    public Task134() throws NoSuchAlgorithmException {
        this.keyStore = new HashMap<>();
        this.secureRandom = SecureRandom.getInstanceStrong();
    }
    
    public String generateKey(int validityHours) throws NoSuchAlgorithmException {
        // Generate cryptographically secure key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(KEY_SIZE, secureRandom);
        SecretKey key = keyGen.generateKey();
        
        // Generate random key ID
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);
        String keyId = Base64.getEncoder().encodeToString(randomBytes);
        
        // Store key with creation and expiration time
        Instant now = Instant.now();
        Instant expiration = now.plus(validityHours, ChronoUnit.HOURS);
        keyStore.put(keyId, new KeyEntry(key, now, expiration));
        
        return keyId;
    }
    
    public SecretKey getKey(String keyId) {
        KeyEntry entry = keyStore.get(keyId);
        if (entry == null) {
            return null;
        }
        
        // Check if key has expired
        if (Instant.now().isAfter(entry.expirationTime)) {
            keyStore.remove(keyId);
            return null;
        }
        
        return entry.key;
    }
    
    public void revokeKey(String keyId) {
        keyStore.remove(keyId);
    }
    
    public boolean isKeyValid(String keyId) {
        KeyEntry entry = keyStore.get(keyId);
        if (entry == null) {
            return false;
        }
        return !Instant.now().isAfter(entry.expirationTime);
    }
    
    public static void main(String[] args) {
        try {
            Task134 keyManager = new Task134();
            
            // Test case 1: Generate and retrieve key
            String keyId1 = keyManager.generateKey(24);
            SecretKey key1 = keyManager.getKey(keyId1);
            System.out.println("Test 1 - Key generated and retrieved: " + (key1 != null));
            
            // Test case 2: Check key validity
            boolean isValid = keyManager.isKeyValid(keyId1);
            System.out.println("Test 2 - Key is valid: " + isValid);
            
            // Test case 3: Revoke key
            keyManager.revokeKey(keyId1);
            boolean isRevoked = (keyManager.getKey(keyId1) == null);
            System.out.println("Test 3 - Key is revoked: " + isRevoked);
            
            // Test case 4: Handle invalid key ID
            SecretKey invalidKey = keyManager.getKey("invalid-id");
            System.out.println("Test 4 - Invalid key returns null: " + (invalidKey == null));
            
            // Test case 5: Generate multiple keys
            String keyId2 = keyManager.generateKey(48);
            String keyId3 = keyManager.generateKey(72);
            System.out.println("Test 5 - Multiple keys generated: " + 
                             (keyManager.isKeyValid(keyId2) && keyManager.isKeyValid(keyId3)));
            
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Cryptographic algorithm not available: " + e.getMessage());
        }
    }
}
