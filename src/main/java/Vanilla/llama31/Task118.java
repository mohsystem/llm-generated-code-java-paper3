package Vanilla.llama31;
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

    private static String validateIPv4(String IP) {
        String[] segments = IP.split("\\.");
        if (segments.length != 4) return "Neither";
        for (String segment : segments) {
            if (!segment.matches("\\d{1,3}")) return "Neither";
            int val = Integer.parseInt(segment);
            if (val < 0 || val > 255 || String.valueOf(val).length() != segment.length()) return "Neither";
        }
        return "IPv4";
    }

    private static String validateIPv6(String IP) {
        String[] segments = IP.split(":");
        if (segments.length != 8) return "Neither";
        for (String segment : segments) {
            if (!segment.matches("[0-9a-fA-F]{1,4}")) return "Neither";
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("192.168.1.1"));  // IPv4
        System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));  // IPv6
        System.out.println(validIPAddress("256.1.1.1"));  // Neither
        System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:73345"));  // Neither
        System.out.println(validIPAddress("192.168.1"));  // Neither
    }
}