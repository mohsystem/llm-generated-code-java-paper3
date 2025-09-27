package Vanilla.llama31;
public class Task67 {
    public static void main(String[] args) {
        String[] testCases = {"user1", "user2", "user3", "nonexistentuser", "anotheruser"};
        for (String testCase : testCases) {
            System.out.println("Testing with username: " + testCase);
            getCustomerInfo(testCase);
        }
    }

    public static void getCustomerInfo(String customerUsername) {
        // The getCustomerInfo method as defined above
    }
}