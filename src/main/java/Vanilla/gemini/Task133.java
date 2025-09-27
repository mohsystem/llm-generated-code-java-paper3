package Vanilla.gemini;
import java.util.Random;

class Task133 {

    public String resetPassword(String username) {
        // Generate a random password of length 8
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*()";
        Random random = new Random();
        StringBuilder newPassword = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            newPassword.append(characters.charAt(random.nextInt(characters.length())));
        }

        return newPassword.toString();
    }

    public static void main(String[] args) {
        Task133 passwordReset = new Task133();
        System.out.println(passwordReset.resetPassword("user1"));
        System.out.println(passwordReset.resetPassword("user2"));
        System.out.println(passwordReset.resetPassword("user3"));
        System.out.println(passwordReset.resetPassword("user4"));
        System.out.println(passwordReset.resetPassword("user5"));
    }
}