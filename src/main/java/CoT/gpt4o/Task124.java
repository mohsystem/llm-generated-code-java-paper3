package CoT.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task124 {
    private List<String> sensitiveData;

    public Task124() {
        this.sensitiveData = new ArrayList<>();
    }

    public void addData(String data) {
        if (isValidData(data)) {
            sensitiveData.add(encryptData(data));
        }
    }

    public String getData(int index) {
        if (index >= 0 && index < sensitiveData.size()) {
            return decryptData(sensitiveData.get(index));
        }
        return null;
    }

    private boolean isValidData(String data) {
        return data != null && !data.trim().isEmpty();
    }

    private String encryptData(String data) {
        // Simple encryption (for illustration only, not secure for real-world use)
        return new StringBuilder(data).reverse().toString();
    }

    private String decryptData(String data) {
        // Simple decryption (for illustration only, not secure for real-world use)
        return new StringBuilder(data).reverse().toString();
    }

    public static void main(String[] args) {
        Task124 storage = new Task124();
        storage.addData("1234-5678-9012-3456");
        storage.addData("John Doe");
        storage.addData("9876-5432-1098-7654");
        storage.addData("Jane Smith");
        storage.addData("2345-6789-0123-4567");

        for (int i = 0; i < 5; i++) {
            System.out.println(storage.getData(i));
        }
    }
}