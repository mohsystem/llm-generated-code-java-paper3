package ourMethod.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task73 {

    public boolean isValidAdminPassword(String password) {
        if (password == null || password.length() < 12) {
            return false;
        }

        // Check for at least one uppercase letter, one lowercase letter, and one digit
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{12,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Task73 task73 = new Task73();

        // Test cases
        String[] passwords = {
                "Admin123", // Invalid: Too short
                "admin12345678", // Invalid: No uppercase
                "ADMIN12345678", // Invalid: No lowercase
                "AdminPassword", // Invalid: No digit
                "AdminPassword123", // Valid
                null,  //Invalid: null password
                "1234567890ABcd", // Valid
                "          ", // Invalid: Too short and no required characters
                "!@#$%^&*()_+=-`~[]\';,./{}|:\"<>?", // Invalid: No required characters
                "Admin1" // Invalid: Too short

        };
        boolean[] expected = {
                false,
                false,
                false,
                false,
                true,
                false,
                true,
                false,
                false,
                false
        };


        for (int i = 0; i < passwords.length; i++) {
            boolean result = task73.isValidAdminPassword(passwords[i]);
            System.out.println("Password: \"" + passwords[i] + "\" - Valid: " + result + ", Expected " + expected[i]);

        }
    }
}