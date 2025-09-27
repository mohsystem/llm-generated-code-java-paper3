package Vanilla.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task124 {
    private List<String> sensitiveData = new ArrayList<>();

    public void storeData(String data) {
        sensitiveData.add(encrypt(data));
    }

    public String retrieveData(int index) {
        if (index >= 0 && index < sensitiveData.size()) {
            return decrypt(sensitiveData.get(index));
        }
        return null;
    }

    private String encrypt(String data) {
        // Simple encryption for demonstration purposes
        return new StringBuilder(data).reverse().toString();
    }

    private String decrypt(String data) {
        // Simple decryption for demonstration purposes
        return new StringBuilder(data).reverse().toString();
    }

    public static void main(String[] args) {
        Task124 task = new Task124();
        task.storeData("1234-5678-9012-3456");
        task.storeData("Alice Wonderland");
        task.storeData("9876-5432-1098-7654");
        task.storeData("Bob Builder");
        task.storeData("4321-8765-2109-6543");

        System.out.println(task.retrieveData(0));
        System.out.println(task.retrieveData(1));
        System.out.println(task.retrieveData(2));
        System.out.println(task.retrieveData(3));
        System.out.println(task.retrieveData(4));
    }
}