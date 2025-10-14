package ZeroShot.openai;
import java.util.Base64;

public class Task124 {
    public static void main(String[] args) {
        String[] testCases = {
            "1234-5678-9012-3456",
            "9876-5432-1098-7654",
            "1111-2222-3333-4444",
            "5555-6666-7777-8888",
            "9999-0000-1111-2222"
        };
        
        for (String cardNumber : testCases) {
            String encrypted = encrypt(cardNumber);
            String decrypted = decrypt(encrypted);
            System.out.println("Original: " + cardNumber);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println();
        }
    }

    private static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private static String decrypt(String data) {
        return new String(Base64.getDecoder().decode(data));
    }
}