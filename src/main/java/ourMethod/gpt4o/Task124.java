package ourMethod.gpt4o;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.KeyGenerator;
import java.security.Key;

public class Task124 {
    private Key key;

    public Task124() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); 
        this.key = keyGen.generateKey();
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encryptedData);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted);
    }

    public static void main(String[] args) {
        try {
            Task124 task = new Task124();

            List<String> sensitiveData = new ArrayList<>();
            sensitiveData.add("4111111111111111"); 
            sensitiveData.add("John Doe"); 
            sensitiveData.add("123456789"); 
            sensitiveData.add("01/23"); 
            sensitiveData.add("987"); 

            List<String> encryptedData = new ArrayList<>();
            for (String data : sensitiveData) {
                encryptedData.add(task.encrypt(data));
            }

            for (String encrypted : encryptedData) {
                System.out.println("Decrypted: " + task.decrypt(encrypted));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}