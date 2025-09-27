package CoT.gpt4o;
public class Task125 {

    public static String accessResource(String userInput) {
        switch (userInput.toLowerCase()) {
            case "resource1":
                return "Accessing Resource 1";
            case "resource2":
                return "Accessing Resource 2";
            case "resource3":
                return "Accessing Resource 3";
            default:
                return "Invalid resource";
        }
    }

    public static void main(String[] args) {
        System.out.println(accessResource("resource1")); // Accessing Resource 1
        System.out.println(accessResource("resource2")); // Accessing Resource 2
        System.out.println(accessResource("RESOURCE3")); // Accessing Resource 3
        System.out.println(accessResource("resource4")); // Invalid resource
        System.out.println(accessResource("RESOURCE1")); // Accessing Resource 1
    }
}