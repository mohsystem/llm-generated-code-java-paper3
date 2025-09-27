package Vanilla.gemini;
class Task125 {
    public String accessResource(String resourceName) {
        // Replace with actual resource access logic
        switch (resourceName) {
            case "resource1":
                return "Accessing resource 1";
            case "resource2":
                return "Accessing resource 2";
            case "resource3":
                return "Accessing resource 3";
            default:
                return "Resource not found";
        }
    }

    public static void main(String[] args) {
        Task125 task = new Task125();
        System.out.println(task.accessResource("resource1"));
        System.out.println(task.accessResource("resource2"));
        System.out.println(task.accessResource("resource3"));
        System.out.println(task.accessResource("resource4"));
        System.out.println(task.accessResource("resource5"));

    }
}