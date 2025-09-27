package ourMethod.codestral;
import java.util.regex.Pattern;

public class Task118 {
    private static final Pattern IPV4_PATTERN =
        Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

    public static boolean isValidIp(String ip) {
        return IPV4_PATTERN.matcher(ip).matches();
    }

    public static void main(String[] args) {
        String[] testCases = {"192.168.1.1", "256.0.0.0", "127.0.0.1", "192.168.0.", "192.168.0.1.1"};
        for (String ip : testCases) {
            System.out.println(ip + " is valid: " + isValidIp(ip));
        }
    }
}