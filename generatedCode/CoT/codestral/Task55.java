package CoT.codestral;
public class Task55 {
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("test.email@example.com")); // true
        System.out.println(isValidEmail("invalid.email")); // false
        System.out.println(isValidEmail("test@sub.example.co")); // true
        System.out.println(isValidEmail("test@sub@example.com")); // false
        System.out.println(isValidEmail("test.email@example")); // false
    }
}