package Vanilla.gpt4o;
public class Task24 {
    public static boolean isValidPin(String pin) {
        return pin.matches("\\d{4}|\\d{6}");
    }

    public static void main(String[] args) {
        System.out.println(isValidPin("1234"));  // true
        System.out.println(isValidPin("12345")); // false
        System.out.println(isValidPin("a234"));  // false
        System.out.println(isValidPin("123456")); // true
        System.out.println(isValidPin("123a"));  // false
    }
}