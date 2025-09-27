package Vanilla.claude;

public class Task24 {
    public static boolean validatePIN(String pin) {
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
        System.out.println(validatePIN("1234")); // true
        System.out.println(validatePIN("12345")); // false
        System.out.println(validatePIN("a234")); // false
        System.out.println(validatePIN("123456")); // true
        System.out.println(validatePIN("")); // false
    }
}
