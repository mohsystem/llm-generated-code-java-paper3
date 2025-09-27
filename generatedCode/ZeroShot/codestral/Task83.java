package ZeroShot.codestral;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task83 {
    public static String encryptAES(String key, String input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivspec = new IvParameterSpec(key.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes(StandardCharsets.UTF_8)));
    }

    public static void main(String[] args) throws Exception {
        String key = "1234567890123456";
        String[] testCases = {"Test1", "Test2", "Test3", "Test4", "Test5"};
        for (String testCase : testCases) {
            System.out.println("Encrypted: " + encryptAES(key, testCase));
        }
    }
}