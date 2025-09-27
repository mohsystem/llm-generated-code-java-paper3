package CoT.llama31;
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
        String[] octets = ip.split("\\.");
        if (octets.length != 4) {
            return "Neither";
        }
        for (String octet : octets) {
            try {
                int num = Integer.parseInt(octet);
                if (num < 0 || num > 255 || (octet.length() > 1 && octet.startsWith("0"))) {
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
            if (segment.length() > 4 || segment.length() < 1) {
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
        System.out.println(validIPAddress("192.168.1.1")); // IPv4
        System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); // IPv6
        System.out.println(validIPAddress("256.1.1.1")); // Neither
        System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:733g")); // Neither
        System.out.println(validIPAddress("192.168.1")); // Neither
    }
}