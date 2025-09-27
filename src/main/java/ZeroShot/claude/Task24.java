package ZeroShot.claude;

public class Task24 {
    public static boolean validatePin(String pin) {
        if (pin == null || (pin.length() != 4 && pin.length() != 6)) {
            return false;
        }
        for (char c : pin.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(validatePin("1234")); // true
        System.out.println(validatePin("12345")); // false
        System.out.println(validatePin("a234")); // false
        System.out.println(validatePin("123456")); // true
        System.out.println(validatePin("")); // false
    }
}
