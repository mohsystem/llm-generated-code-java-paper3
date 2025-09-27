package Vanilla.gpt4o;
public class Task133 {
    public static String resetPassword(String username, String oldPassword, String newPassword) {
        // This is a mock function; in a real scenario, it would interact with a database
        if (oldPassword.equals("oldPass")) {
            return "Password reset successful for user: " + username;
        } else {
            return "Password reset failed for user: " + username;
        }
    }

    public static void main(String[] args) {
        System.out.println(resetPassword("user1", "oldPass", "newPass1"));
        System.out.println(resetPassword("user2", "wrongPass", "newPass2"));
        System.out.println(resetPassword("user3", "oldPass", "newPass3"));
        System.out.println(resetPassword("user4", "oldPass", "newPass4"));
        System.out.println(resetPassword("user5", "wrongPass", "newPass5"));
    }
}