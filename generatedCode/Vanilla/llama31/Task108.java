package Vanilla.llama31;
// Task108.java
public class Task108 {
    public static void main(String[] args) {
        // Test cases
        String[] testMessages = {"Test Message 1", "Test Message 2", "Test Message 3", "Test Message 4", "Test Message 5"};

        try {
            ServerRemote server = (ServerRemote) Naming.lookup("rmi://localhost:1099/MyRemoteObject");
            for (String message : testMessages) {
                server.setMessage(message);
                System.out.println("Message: " + server.getMessage());
                System.out.println("Current Date: " + server.getDate());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}