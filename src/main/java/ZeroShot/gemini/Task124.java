package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.List;

class Task124 {
    private static final List<EncryptedData> encryptedDataList = new ArrayList<>();

    private static class EncryptedData {
        private final byte[] encryptedData;

        public EncryptedData(byte[] encryptedData) {
            this.encryptedData = encryptedData;
        }

        public byte[] getEncryptedData() {
            return encryptedData;
        }
    }


    public static void storeData(String data) {
        try {
            byte[] encrypted = encryptData(data.getBytes());
            encryptedDataList.add(new EncryptedData(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String retrieveData(int index) {
        try {
            if (index >= 0 && index < encryptedDataList.size()) {
                byte[] decrypted = decryptData(encryptedDataList.get(index).getEncryptedData());
                return new String(decrypted);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private static byte[] encryptData(byte[] data) throws Exception {
        // Implement strong encryption here e.g., AES
        return data;
    }


    private static byte[] decryptData(byte[] encryptedData) throws Exception {
        // Implement decryption using the same algorithm and key as encryption
        return encryptedData;
    }


    public static void main(String[] args) {
        storeData("1234-5678-9012-3456");
        storeData("John Doe");
        storeData("jane.doe@example.com");
        storeData("9876-5432-1098-7654");
        storeData("Jane Smith");

        System.out.println(retrieveData(0));
        System.out.println(retrieveData(1));
        System.out.println(retrieveData(2));
        System.out.println(retrieveData(3));
        System.out.println(retrieveData(4));
    }
}