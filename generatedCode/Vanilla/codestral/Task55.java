package Vanilla.codestral;
public class Task55 {
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }
    public static void main(String[] args) {
        System.out.println(isValidEmail("test@example.com")); // true
        System.out.println(isValidEmail("test@.com")); // false
        System.out.println(isValidEmail("test@example")); // false
        System.out.println(isValidEmail("test@example.c")); // false
        System.out.println(isValidEmail("test@example.com.au")); // true
    }
}