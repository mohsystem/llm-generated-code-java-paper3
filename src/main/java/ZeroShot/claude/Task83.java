package ZeroShot.claude;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task83 {
    public static String encryptAES(String plaintext, String key) {
        try {
            byte[] clean = plaintext.getBytes();
            byte[] raw = key.getBytes();
            
            // Pad key if needed
            if (raw.length != 16) { 
                byte[] tmp = new byte[16];
                System.arraycopy(raw, 0, tmp, 0, Math.min(raw.length, 16));
                raw = tmp;
            }

            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            
            // Create IV
            byte[] iv = new byte[16];
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivSpec);
            byte[] encrypted = cipher.doFinal(clean);
            return Base64.getEncoder().encodeToString(encrypted);
            
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String key = "ThisIsA16ByteKey";
        
        System.out.println("Test 1: " + encryptAES("Hello World", key));
        System.out.println("Test 2: " + encryptAES("SecretMessage123", key));
        System.out.println("Test 3: " + encryptAES("Testing AES CBC", key));
        System.out.println("Test 4: " + encryptAES("Confidential Data", key));
        System.out.println("Test 5: " + encryptAES("AES Encryption Test", key));
    }
}
