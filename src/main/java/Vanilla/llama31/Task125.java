package Vanilla.llama31;
public class Task125 {
    public static void main(String[] args) {
        // Test cases
        accessResource("Resource1");
        accessResource("Resource2");
        accessResource("Resource3");
        accessResource("InvalidResource");
        accessResource("Resource1");
    }

    public static void accessResource(String resourceName) {
        if (resourceName.equals("Resource1")) {
            System.out.println("Accessing Resource1");
        } else if (resourceName.equals("Resource2")) {
            System.out.println("Accessing Resource2");
        } else if (resourceName.equals("Resource3")) {
            System.out.println("Accessing Resource3");
        } else {
            System.out.println("Resource not found");
        }
    }
}