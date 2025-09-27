package ourMethod.gemini;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

class Task72 {
    private static final byte[] IV = new byte[16];

    static {
        try {
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(IV);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String encrypt(String data, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        byte[] encryptedData = cipher.doFinal(data.getBytes());

        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static void main(String[] args) throws Exception {

        String key = "0123456789abcdef0123456789abcdef"; // Example 32 byte key

        String data1 = "Test data 1";
        String encryptedData1 = encrypt(data1, key);
        System.out.println("Encrypted Data 1: " + encryptedData1);


        String data2 = "Test data 2 slightly longer";
        String encryptedData2 = encrypt(data2, key);
        System.out.println("Encrypted Data 2: " + encryptedData2);


        String data3 = "Short";
        String encryptedData3 = encrypt(data3, key);
        System.out.println("Encrypted Data 3: " + encryptedData3);


        String data4 = "Special characters !@#$%^&*()_+=-`~[]\';,./{}|:\"<>?";
        String encryptedData4 = encrypt(data4, key);
        System.out.println("Encrypted Data 4: " + encryptedData4);


        String data5 = "1234567890123456";
        String encryptedData5 = encrypt(data5, key);
        System.out.println("Encrypted Data 5: " + encryptedData5);
    }
}