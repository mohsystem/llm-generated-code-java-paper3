package CoT.gpt4o;
public class Task24 {
    public static boolean isValidPIN(String pin) {
        if (pin == null) {
            return false;
        }
        return pin.matches("\\d{4}|\\d{6}");
    }

    public static void main(String[] args) {
        System.out.println(isValidPIN("1234"));  // true
        System.out.println(isValidPIN("12345")); // false
        System.out.println(isValidPIN("a234"));  // false
        System.out.println(isValidPIN("123456")); // true
        System.out.println(isValidPIN("12b456")); // false
    }
}