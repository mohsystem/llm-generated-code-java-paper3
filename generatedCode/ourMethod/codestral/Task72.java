package ourMethod.codestral;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.util.Base64;

public class Task72 {
    public static String encrypt(String input) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key key = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        AlgorithmParameters params = cipher.getParameters();
        byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();

        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        byte[] combinedBytes = new byte[iv.length + encryptedBytes.length];
        System.arraycopy(iv, 0, combinedBytes, 0, iv.length);
        System.arraycopy(encryptedBytes, 0, combinedBytes, iv.length, encryptedBytes.length);

        return Base64.getEncoder().encodeToString(combinedBytes);
    }

    public static void main(String[] args) throws Exception {
        String[] testCases = {"Hello, World!", "Test Case 2", "This is a longer test case.", "", " "};
        for (String testCase : testCases) {
            String encrypted = encrypt(testCase);
            System.out.println("Original: " + testCase);
            System.out.println("Encrypted: " + encrypted);
            System.out.println();
        }
    }
}