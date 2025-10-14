package ourMethodv2.gpt4o;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task124 {

    private static final String ENCRYPTION_ALGO = "AES/GCM/NoPadding";
    private static final int GCM_TAG_LENGTH = 16;
    private static final int GCM_IV_LENGTH = 12;
    private SecretKey secretKey;

    public Task124() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        this.secretKey = keyGen.generateKey();
    }

    public String encryptData(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGO);
        byte[] iv = new byte[GCM_IV_LENGTH];
        SecureRandom.getInstanceStrong().nextBytes(iv);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        byte[] encryptedDataWithIv = new byte[iv.length + encryptedData.length];
        System.arraycopy(iv, 0, encryptedDataWithIv, 0, iv.length);
        System.arraycopy(encryptedData, 0, encryptedDataWithIv, iv.length, encryptedData.length);
        return Base64.getEncoder().encodeToString(encryptedDataWithIv);
    }

    public String decryptData(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGO);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] iv = new byte[GCM_IV_LENGTH];
        System.arraycopy(decodedData, 0, iv, 0, iv.length);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
        byte[] originalData = cipher.doFinal(decodedData, iv.length, decodedData.length - iv.length);
        return new String(originalData);
    }

    public static void main(String[] args) throws Exception {
        Task124 task = new Task124();
        String[] testCases = {
            "1234-5678-9876-5432",
            "4111-1111-1111-1111",
            "5555-5555-5555-4444",
            "6011-0009-9013-9424",
            "3782-822463-10005"
        };

        for (String testCase : testCases) {
            String encrypted = task.encryptData(testCase);
            String decrypted = task.decryptData(encrypted);
            System.out.println("Original: " + testCase);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println();
        }
    }
}