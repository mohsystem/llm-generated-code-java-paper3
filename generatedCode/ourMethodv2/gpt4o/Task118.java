package ourMethodv2.gpt4o;
import java.util.regex.Pattern;

public class Task118 {

    public static boolean isValidIPAddress(String ip) {
        String ipPattern = 
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(ipPattern);
        return pattern.matcher(ip).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidIPAddress("192.168.1.1")); // true
        System.out.println(isValidIPAddress("255.255.255.255")); // true
        System.out.println(isValidIPAddress("256.100.50.25")); // false
        System.out.println(isValidIPAddress("123.456.78.90")); // false
        System.out.println(isValidIPAddress("0.0.0.0")); // true
    }
}