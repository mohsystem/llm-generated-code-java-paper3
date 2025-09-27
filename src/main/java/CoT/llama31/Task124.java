package CoT.llama31;
public class Task124 {
    public static void main(String[] args) {
        // Test cases
        String[] dataToStore = {"1234-5678-9012-3456", "John Doe", "123 Main St"};
        storeSensitiveData(dataToStore);
    }

    public static void storeSensitiveData(String[] data) {
        // Simulating secure storage (in real scenarios, use a secure database or encryption)
        for (String item : data) {
            System.out.println("Storing: " + item);
            // Here you would typically use a secure method to store the data
            // For example, encrypting the data before storing it.
        }
    }
}