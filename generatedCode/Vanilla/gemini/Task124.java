package Vanilla.gemini;
import java.util.ArrayList;
import java.util.List;

class Task124 {
    private List<String> sensitiveData;

    public Task124() {
        sensitiveData = new ArrayList<>();
    }

    public void addData(String data) {
        sensitiveData.add(data);
    }

    public String getData(int index) {
        if (index >= 0 && index < sensitiveData.size()) {
            return sensitiveData.get(index);
        }
        return null;
    }


    public static void main(String[] args) {
        Task124 dataStore = new Task124();

        // Test cases
        dataStore.addData("1234-5678-9012-3456");
        dataStore.addData("John Doe");
        dataStore.addData("9876-5432-1098-7654");
        dataStore.addData("Jane Smith");
        dataStore.addData("5454-1212-7878-4545");


        System.out.println(dataStore.getData(0)); // 1234-5678-9012-3456
        System.out.println(dataStore.getData(1)); // John Doe
        System.out.println(dataStore.getData(2)); // 9876-5432-1098-7654
        System.out.println(dataStore.getData(3)); // Jane Smith
        System.out.println(dataStore.getData(4)); // 5454-1212-7878-4545


    }
}