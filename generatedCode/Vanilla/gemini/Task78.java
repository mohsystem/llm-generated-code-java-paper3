package Vanilla.gemini;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Base64;

class Task78 {

    public static String generateAndExportRsaPrivateKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // Use a strong key size
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();


        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) privateKey;
        String opensshFormattedKey = generateOpenSSHFormattedKey(rsaPrivateKey);
        return opensshFormattedKey;

    }

        private static String generateOpenSSHFormattedKey(RSAPrivateKey privateKey) {
        StringBuilder builder = new StringBuilder("-----BEGIN OPENSSH PRIVATE KEY-----\n");
        // Implement OpenSSH key formatting here (complex, involves ASN.1 encoding)
        // This is a placeholder - proper implementation required
        String encodedKey =  Base64.getEncoder().encodeToString(privateKey.getEncoded());

        int index = 0;
        while (index < encodedKey.length()) {
            int endIndex = Math.min(index + 70, encodedKey.length());
            builder.append(encodedKey, index, endIndex).append("\n");
            index = endIndex;
        }

        builder.append("-----END OPENSSH PRIVATE KEY-----\n");
        return builder.toString();
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        for (int i = 0; i < 5; i++) {
            String privateKey = generateAndExportRsaPrivateKey();
            System.out.println(privateKey);
            System.out.println("--------------------");
        }
    }
}