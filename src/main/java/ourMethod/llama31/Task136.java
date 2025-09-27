package ourMethod.llama31;
public class Task136 {
    public static boolean authenticate(String username, String password, String validUsername, String validPassword) {
        return username.equals(validUsername) && password.equals(validPassword);
    }

    public static void main(String[] args) {
        String validUsername = "user";
        String validPassword = "user";

        // Test cases
        String[] usernames = {"user", "invalid", "user", "user"};
        String[] passwords = {"user", "user", "invalid", "user"};

        for (int i = 0; i < usernames.length; i++) {
            if (authenticate(usernames[i], passwords[i], validUsername, validPassword)) {
                System.out.println("Authentication Successful");
            } else {
                System.out.println("Authentication Failed");
            }
        }
    }
}