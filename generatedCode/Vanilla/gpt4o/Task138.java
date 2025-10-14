package Vanilla.openai;
class Task138 {
    private String username;
    private String role;

    public Task138(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getPrivileges() {
        switch (role.toLowerCase()) {
            case "admin":
                return "All Access";
            case "editor":
                return "Edit Access";
            case "viewer":
                return "View Access";
            default:
                return "No Access";
        }
    }

    public static void main(String[] args) {
        Task138 user1 = new Task138("Alice", "admin");
        Task138 user2 = new Task138("Bob", "editor");
        Task138 user3 = new Task138("Charlie", "viewer");
        Task138 user4 = new Task138("David", "guest");
        Task138 user5 = new Task138("Eve", "admin");

        System.out.println(user1.username + ": " + user1.getPrivileges());
        System.out.println(user2.username + ": " + user2.getPrivileges());
        System.out.println(user3.username + ": " + user3.getPrivileges());
        System.out.println(user4.username + ": " + user4.getPrivileges());
        System.out.println(user5.username + ": " + user5.getPrivileges());
    }
}