package CoT.llama31;
public class Task136 {
    public static boolean authenticateUser(String username, String password, String validUsername, String validPassword) {
        return username.equals(validUsername) && password.equals(validPassword);
    }

    public static void main(String[] args) {
        String validUsername = "user123";
        String validPassword = "password";

        // Test cases
        System.out.println(authenticateUser("user123", "password", validUsername, validPassword) ? "Authentication Successful" : "Authentication Failed");
        System.out.println(authenticateUser("user123", "wrongpassword", validUsername, validPassword) ? "Authentication Successful" : "Authentication Failed");
        System.out.println(authenticateUser("wronguser", "password", validUsername, validPassword) ? "Authentication Successful" : "Authentication Failed");
        System.out.println(authenticateUser("wronguser", "wrongpassword", validUsername, validPassword) ? "Authentication Successful" : "Authentication Failed");
        System.out.println(authenticateUser("user123", "password", validUsername, validPassword) ? "Authentication Successful" : "Authentication Failed");
    }
}