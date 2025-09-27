package ourMethod.gemini;
import java.util.regex.Pattern;

class Task24 {
    public boolean validatePin(String pin) {
        return Pattern.matches("\\d{4}|\\d{6}", pin);
    }

    public static void main(String[] args) {
        Task24 task24 = new Task24();
        System.out.println(task24.validatePin("1234")); // true
        System.out.println(task24.validatePin("12345")); // false
        System.out.println(task24.validatePin("a234")); // false
        System.out.println(task24.validatePin("123456")); // true
        System.out.println(task24.validatePin("1234567")); // false

    }
}