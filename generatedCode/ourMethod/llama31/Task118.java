package ourMethod.llama31;
public class Task118 {
    public static String validIPAddress(String IP) {
        if (IP.contains(".")) {
            return validateIPv4(IP);
        } else if (IP.contains(":")) {
            return validateIPv6(IP);
        } else {
            return "Neither";
        }
    }

    public static String validateIPv4(String ip) {
        String[] segments = ip.split("\\.");
        if (segments.length != 4) {
            return "Neither";
        }
        for (String segment : segments) {
            if (segment.isEmpty() || segment.length() > 3 || (segment.length() > 1 && segment.startsWith("0"))) {
                return "Neither";
            }
            try {
                int num = Integer.parseInt(segment);
                if (num < 0 || num > 255) {
                    return "Neither";
                }
            } catch (NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public static String validateIPv6(String ip) {
        String[] segments = ip.split(":");
        if (segments.length != 8) {
            return "Neither";
        }
        for (String segment : segments) {
            if (segment.isEmpty() || segment.length() > 4) {
                return "Neither";
            }
            try {
                int num = Integer.parseInt(segment, 16);
                if (num < 0 || num > 65535) {
                    return "Neither";
                }
            } catch (NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        String[] testCases = {"192.168.1.1", "2001:0db8:85a3:0000:0000:8a2e:0370:7334", "256.1.1.1", "2001:0db8:85a3:0000:0000:8a2e:0370:733g"};
        for (String testCase : testCases) {
            System.out.println(validIPAddress(testCase));
        }
    }
}