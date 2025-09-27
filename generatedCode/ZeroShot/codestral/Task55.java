package ZeroShot.codestral;
public class Task55 {
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("test@example.com"));  // true
        System.out.println(isValidEmail("test@example"));     // false
        System.out.println(isValidEmail("test@.com"));         // false
        System.out.println(isValidEmail("test@example..com")); // false
        System.out.println(isValidEmail("test@example-com"));  // false
    }
}