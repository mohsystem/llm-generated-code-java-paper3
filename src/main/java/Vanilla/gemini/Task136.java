package Vanilla.gemini;
class Task136 {
    public boolean authenticateUser(String username, String password) {
        // In a real application, you would typically query a database or external service
        // to verify the username and password.
        // For this example, we'll use hardcoded credentials.
        if (username.equals("user123") && password.equals("password456")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Task136 auth = new Task136();
        System.out.println(auth.authenticateUser("user123", "password456")); // true
        System.out.println(auth.authenticateUser("user123", "wrongpassword")); // false
        System.out.println(auth.authenticateUser("wronguser", "password456")); // false
        System.out.println(auth.authenticateUser("", "")); // false
        System.out.println(auth.authenticateUser("user123 ", "password456")); //false

    }
}