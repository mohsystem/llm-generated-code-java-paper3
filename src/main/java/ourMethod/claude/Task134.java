package ourMethod.claude;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Task134 {
    private static final String MAGIC = "KEY1";
    private static final int VERSION = 1;
    private static final int SALT_SIZE = 16;
    private static final int IV_SIZE = 12;
    private static final int TAG_SIZE = 16;
    private static final int ITERATIONS = 210000;
    private static final String KEY_ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/GCM/NoPadding";
    private static final String KDF_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int KEY_SIZE = 256;

    private final Path baseDirectory;
    private final ReentrantLock lock = new ReentrantLock();

    public Task134(String baseDir) throws IOException {
        if (baseDir == null || baseDir.isEmpty()) {
            throw new IllegalArgumentException("Base directory cannot be null or empty");
        }
        this.baseDirectory = Paths.get(baseDir).toAbsolutePath().normalize();
        Files.createDirectories(this.baseDirectory);
    }

    private Path validatePath(String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        if (filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
            throw new IllegalArgumentException("Invalid filename");
        }
        Path resolved = this.baseDirectory.resolve(filename).normalize();
        if (!resolved.startsWith(this.baseDirectory)) {
            throw new SecurityException("Path traversal detected");
        }
        return resolved;
    }

    private byte[] deriveKey(char[] passphrase, byte[] salt) throws Exception {
        if (passphrase == null || passphrase.length == 0) {
            throw new IllegalArgumentException("Passphrase cannot be null or empty");
        }
        if (salt == null || salt.length != SALT_SIZE) {
            throw new IllegalArgumentException("Invalid salt size");
        }

        PBEKeySpec spec = new PBEKeySpec(passphrase, salt, ITERATIONS, KEY_SIZE);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(KDF_ALGORITHM);
            return factory.generateSecret(spec).getEncoded();
        } finally {
            spec.clearPassword();
        }
    }

    public void generateAndStoreKey(String keyName, char[] passphrase) throws Exception {
        if (keyName == null || keyName.isEmpty()) {
            throw new IllegalArgumentException("Key name cannot be null or empty");
        }
        if (passphrase == null || passphrase.length < 12) {
            throw new IllegalArgumentException("Passphrase must be at least 12 characters");
        }

        lock.lock();
        try {
            Path keyPath = validatePath(keyName + ".key");

            SecureRandom random = new SecureRandom();
            byte[] keyMaterial = new byte[32];
            random.nextBytes(keyMaterial);

            byte[] salt = new byte[SALT_SIZE];
            random.nextBytes(salt);

            byte[] iv = new byte[IV_SIZE];
            random.nextBytes(iv);

            byte[] derivedKey = deriveKey(passphrase, salt);
            SecretKeySpec keySpec = new SecretKeySpec(derivedKey, KEY_ALGORITHM);

            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            GCMParameterSpec gcmSpec = new GCMParameterSpec(TAG_SIZE * 8, iv);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmSpec);

            byte[] ciphertext = cipher.doFinal(keyMaterial);

            Path tempPath = Files.createTempFile(this.baseDirectory, "tmp", ".key");
            try (FileOutputStream fos = new FileOutputStream(tempPath.toFile())) {
                fos.write(MAGIC.getBytes(StandardCharsets.UTF_8));
                fos.write(VERSION);
                fos.write(salt);
                fos.write(iv);
                fos.write(ciphertext);
                fos.flush();
                fos.getFD().sync();
            }

            Files.move(
                    tempPath,
                    keyPath,
                    StandardCopyOption.ATOMIC_MOVE,
                    StandardCopyOption.REPLACE_EXISTING
            );

            Arrays.fill(keyMaterial, (byte) 0);
            Arrays.fill(derivedKey, (byte) 0);
        } finally {
            lock.unlock();
        }
    }

    public byte[] retrieveKey(String keyName, char[] passphrase) throws Exception {
        if (keyName == null || keyName.isEmpty()) {
            throw new IllegalArgumentException("Key name cannot be null or empty");
        }
        if (passphrase == null || passphrase.length == 0) {
            throw new IllegalArgumentException("Passphrase cannot be null or empty");
        }

        lock.lock();
        try {
            Path keyPath = validatePath(keyName + ".key");

            if (!Files.isRegularFile(keyPath)) {
                throw new IOException("Key file not found or not a regular file");
            }

            byte[] fileData = Files.readAllBytes(keyPath);

            int minSize = MAGIC.length() + 1 + SALT_SIZE + IV_SIZE + TAG_SIZE;
            if (fileData.length < minSize) {
                throw new SecurityException("Invalid key file format");
            }

            int offset = 0;
            byte[] magic = Arrays.copyOfRange(fileData, offset, offset + MAGIC.length());
            offset += MAGIC.length();

            if (!Arrays.equals(magic, MAGIC.getBytes(StandardCharsets.UTF_8))) {
                throw new SecurityException("Invalid magic number");
            }

            int version = fileData[offset++] & 0xFF;
            if (version != VERSION) {
                throw new SecurityException("Unsupported version");
            }

            byte[] salt = Arrays.copyOfRange(fileData, offset, offset + SALT_SIZE);
            offset += SALT_SIZE;

            byte[] iv = Arrays.copyOfRange(fileData, offset, offset + IV_SIZE);
            offset += IV_SIZE;

            byte[] ciphertext = Arrays.copyOfRange(fileData, offset, fileData.length);

            byte[] derivedKey = deriveKey(passphrase, salt);
            SecretKeySpec keySpec = new SecretKeySpec(derivedKey, KEY_ALGORITHM);

            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            GCMParameterSpec gcmSpec = new GCMParameterSpec(TAG_SIZE * 8, iv);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmSpec);

            byte[] keyMaterial = cipher.doFinal(ciphertext);

            Arrays.fill(derivedKey, (byte) 0);
            return keyMaterial;
        } finally {
            lock.unlock();
        }
    }

    public boolean deleteKey(String keyName) throws Exception {
        if (keyName == null || keyName.isEmpty()) {
            throw new IllegalArgumentException("Key name cannot be null or empty");
        }

        lock.lock();
        try {
            Path keyPath = validatePath(keyName + ".key");
            return Files.deleteIfExists(keyPath);
        } finally {
            lock.unlock();
        }
    }

    public List<String> listKeys() throws Exception {
        lock.lock();
        try {
            List<String> keys = new ArrayList<>();
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(this.baseDirectory, "*.key")) {
                for (Path entry : stream) {
                    if (Files.isRegularFile(entry)) {
                        String filename = entry.getFileName().toString();
                        keys.add(filename.substring(0, filename.length() - 4));
                    }
                }
            }
            return keys;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        try {
            Path tempDir = Files.createTempDirectory("keymanager");
            Task134 keyManager = new Task134(tempDir.toString());

            System.out.println("Test 1: Generate and retrieve key");
            char[] passphrase1 = "SecurePassphrase123!".toCharArray();
            keyManager.generateAndStoreKey("testkey1", passphrase1);
            byte[] key1 = keyManager.retrieveKey("testkey1", passphrase1);
            System.out.println("Key retrieved successfully: " + (key1.length == 32));
            Arrays.fill(key1, (byte) 0);
            Arrays.fill(passphrase1, ' ');

            System.out.println("Test 2: List keys");
            char[] passphrase2 = "AnotherSecure456!".toCharArray();
            keyManager.generateAndStoreKey("testkey2", passphrase2);
            List<String> keys = keyManager.listKeys();
            System.out.println("Keys found: " + keys.size());
            Arrays.fill(passphrase2, ' ');

            System.out.println("Test 3: Invalid passphrase");
            char[] wrongPass = "WrongPassphrase789!".toCharArray();
            try {
                keyManager.retrieveKey("testkey1", wrongPass);
                System.out.println("ERROR: Should have failed");
            } catch (Exception e) {
                System.out.println("Correctly rejected wrong passphrase");
            }
            Arrays.fill(wrongPass, ' ');

            System.out.println("Test 4: Delete key");
            boolean deleted = keyManager.deleteKey("testkey1");
            System.out.println("Key deleted: " + deleted);

            System.out.println("Test 5: Path traversal prevention");
            try {
                keyManager.generateAndStoreKey("../etc/passwd", "test123456789!".toCharArray());
                System.out.println("ERROR: Should have prevented path traversal");
            } catch (IllegalArgumentException e) {
                System.out.println("Path traversal correctly prevented");
            }

            for (String key : keyManager.listKeys()) {
                keyManager.deleteKey(key);
            }
            Files.delete(tempDir);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
