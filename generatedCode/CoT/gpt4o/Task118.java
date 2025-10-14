package CoT.openai;
import java.util.regex.Pattern;

public class Task118 {

    public static boolean isValidIPAddress(String ipAddress) {
        String ipv4Pattern = 
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        String ipv6Pattern = 
            "([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|" +
            "([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}" +
            "(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4})" +
            "{1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}" +
            ":){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4})" +
            "{1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}" +
            "%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|2[0-4][0-9]|" +
            "[01]?[0-9][0-9]?)\\.){3,3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)|" +
            "([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)" +
            "{3,3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern ipv4CompiledPattern = Pattern.compile(ipv4Pattern);
        Pattern ipv6CompiledPattern = Pattern.compile(ipv6Pattern);

        return ipv4CompiledPattern.matcher(ipAddress).matches() ||
               ipv6CompiledPattern.matcher(ipAddress).matches();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "192.168.1.1",    // valid IPv4
            "255.255.255.255", // valid IPv4
            "0.0.0.0",        // valid IPv4
            "256.256.256.256", // invalid IPv4
            "2001:0db8:85a3:0000:0000:8a2e:0370:7334" // valid IPv6
        };

        for (String testCase : testCases) {
            System.out.println(testCase + " is valid: " + isValidIPAddress(testCase));
        }
    }
}