package ourMethodv2.gpt4o;
public class Task24 {
    public static boolean isValidPin(String pin) {
        if (pin == null) return false;
        return (pin.length() == 4 || pin.length() == 6) && pin.matches("\\d+");
    }

    public static void main(String[] args) {
        System.out.println(isValidPin("1234"));   // true
        System.out.println(isValidPin("12345"));  // false
        System.out.println(isValidPin("a234"));   // false
        System.out.println(isValidPin("123456")); // true
        System.out.println(isValidPin("123a56")); // false
    }
}