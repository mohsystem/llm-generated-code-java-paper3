package Vanilla.codestral;
public class Task24 {
    public static boolean validatePin(String pin) {
        return pin.matches("\\d{4}|\\d{6}");
    }

    public static void main(String[] args) {
        System.out.println(validatePin("1234"));   // -->  true
        System.out.println(validatePin("12345"));  // -->  false
        System.out.println(validatePin("a234"));   // -->  false
        System.out.println(validatePin("123456")); // -->  true
        System.out.println(validatePin("1234567")); // -->  false
    }
}