package Vanilla.gpt4o;
public class Task134 {
    public static void main(String[] args) {
        System.out.println(manageKeys("generate"));
        System.out.println(manageKeys("encrypt", "hello", "key"));
        System.out.println(manageKeys("decrypt", "encrypted", "key"));
        System.out.println(manageKeys("list"));
        System.out.println(manageKeys("delete", "key"));
    }

    public static String manageKeys(String action, String... args) {
        switch(action) {
            case "generate":
                return "Key generated";
            case "encrypt":
                return "Encrypted: " + args[0] + " with " + args[1];
            case "decrypt":
                return "Decrypted: " + args[0] + " with " + args[1];
            case "list":
                return "Listing keys";
            case "delete":
                return "Deleted key: " + args[0];
            default:
                return "Invalid action";
        }
    }
}