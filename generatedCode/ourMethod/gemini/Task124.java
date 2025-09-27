package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;

public class Task124 {

    private static final String DEFAULT_ENCRYPTION_ALGORITHM = "AES/GCM/NoPadding"; // Secure default

    static class SecureData {
        private String data;
        private String encryptionAlgorithm;


        public SecureData(String data, String encryptionAlgorithm) {
            if (data == null || data.isEmpty()) {
                throw new IllegalArgumentException("Data cannot be null or empty");
            }

            if (encryptionAlgorithm == null || encryptionAlgorithm.isEmpty()) {
                this.encryptionAlgorithm = DEFAULT_ENCRYPTION_ALGORITHM;
            } else {
                this.encryptionAlgorithm = encryptionAlgorithm;
            }

            // Implement Encryption Here using this.encryptionAlgorithm and this.data
            this.data = encrypt(data, this.encryptionAlgorithm);
        }

        public String retrieveData() {
             return decrypt(data, encryptionAlgorithm);
        }

        private String encrypt(String data, String algorithm) {
            // Placeholder for actual encryption logic using the specified algorithm
            // In real implementation, use a strong library like Jasypt or similar
            return "Encrypted:" + data; // Replace with actual encryption
        }

        private String decrypt(String encryptedData, String algorithm) {
            // Placeholder for actual decryption logic using the specified algorithm
            // In real implementation, use a strong library like Jasypt or similar
            return encryptedData.replace("Encrypted:", ""); // Replace with actual decryption
        }
    }


    public static void main(String[] args) {
        List<SecureData> dataList = new ArrayList<>();

        dataList.add(new SecureData("1234-5678-9012-3456", DEFAULT_ENCRYPTION_ALGORITHM));
        dataList.add(new SecureData("John Doe", "AES/CBC/PKCS5Padding"));
        dataList.add(new SecureData("john.doe@example.com", DEFAULT_ENCRYPTION_ALGORITHM));
        dataList.add(new SecureData("9876543210", DEFAULT_ENCRYPTION_ALGORITHM));
        dataList.add(new SecureData("Jane Smith", "AES/CBC/PKCS5Padding"));


        for (SecureData data : dataList) {
            String retrieved = data.retrieveData();
            System.out.println("Retrieved: " + retrieved);
        }
    }
}