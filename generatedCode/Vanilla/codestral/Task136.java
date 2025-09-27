package Vanilla.codestral;
public class Task136 {
    public static boolean authenticate(String username, String password) {
        // Replace these with your secure method of user verification
        String correctUsername = "user";
        String correctPassword = "password";

        return username.equals(correctUsername) && password.equals(correctPassword);
    }

    public static void main(String[] args) {
        System.out.println(authenticate("user", "password")); // true
        System.out.println(authenticate("user", "wrong")); // false
        System.out.println(authenticate("wrong", "password")); // false
        System.out.println(authenticate("wrong", "wrong")); // false
    }
}