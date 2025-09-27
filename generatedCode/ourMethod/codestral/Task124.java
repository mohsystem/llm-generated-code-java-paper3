package ourMethod.codestral;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task124 {
    private Map<String, String> sensitiveData = new HashMap<>();

    public void storeData(String key, String data) {
        if (key != null && data != null) {
            // Encrypt the data before storing it
            String encryptedData = encrypt(data);
            sensitiveData.put(key, encryptedData);
        } else {
            throw new IllegalArgumentException("Key and data cannot be null");
        }
    }

    public String retrieveData(String key) {
        if (key != null) {
            String encryptedData = sensitiveData.get(key);
            if (encryptedData != null) {
                // Decrypt the data before returning it
                String decryptedData = decrypt(encryptedData);
                return decryptedData;
            } else {
                throw new IllegalArgumentException("Data not found for the given key");
            }
        } else {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    private String encrypt(String data) {
        // Placeholder for encryption logic
        return data;
    }

    private String decrypt(String data) {
        // Placeholder for decryption logic
        return data;
    }

    public static void main(String[] args) {
        Task124 task = new Task124();
        Scanner scanner = new Scanner(System.in);

        // Test case 1: Storing sensitive data
        System.out.print("Enter key for test case 1: ");
        String key1 = scanner.nextLine();
        System.out.print("Enter data for test case 1: ");
        String data1 = scanner.nextLine();
        task.storeData(key1, data1);
        System.out.println("Data stored successfully for test case 1");

        // Test case 2: Retrieving sensitive data
        System.out.print("Enter key for test case 2: ");
        String key2 = scanner.nextLine();
        try {
            String retrievedData = task.retrieveData(key2);
            System.out.println("Retrieved data for test case 2: " + retrievedData);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test case 3: Storing null key
        try {
            task.storeData(null, "test data");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test case 4: Storing null data
        try {
            task.storeData("test key", null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test case 5: Retrieving data with null key
        try {
            task.retrieveData(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}