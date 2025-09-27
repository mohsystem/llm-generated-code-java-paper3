package Vanilla.codestral;
import java.util.regex.Pattern;

public class Task118 {
    public static boolean isValidIP(String ip) {
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        return pattern.matcher(ip).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidIP("192.168.1.1"));  // true
        System.out.println(isValidIP("256.168.1.1"));  // false
        System.out.println(isValidIP("192.168.01.1")); // false
        System.out.println(isValidIP("192.168.1.01")); // false
        System.out.println(isValidIP("192.168.1"));     // false
    }
}