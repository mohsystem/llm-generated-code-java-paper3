package ZeroShot.llama31;
public class Task118 {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            return validateIPv4(IP);
        } else if (IP.contains(":")) {
            return validateIPv6(IP);
        } else {
            return "Neither";
        }
    }

    private String validateIPv4(String ip) {
        String[] segments = ip.split("\\.");
        if (segments.length != 4) {
            return "Neither";
        }
        for (String segment : segments) {
            if (!segment.matches("\\d+") || !isValidIPv4Segment(segment)) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private boolean isValidIPv4Segment(String segment) {
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255 && (segment.length() == 1 || segment.charAt(0) != '0');
    }

    private String validateIPv6(String ip) {
        String[] segments = ip.split(":");
        if (segments.length != 8) {
            return "Neither";
        }
        for (String segment : segments) {
            if (segment.length() > 4 || !segment.matches("[0-9a-fA-F]*")) {
                return "Neither";
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        Task118 task = new Task118();
        System.out.println(task.validIPAddress("192.168.1.1")); // IPv4
        System.out.println(task.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); // IPv6
        System.out.println(task.validIPAddress("256.1.1.1")); // Neither
        System.out.println(task.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:733g")); // Neither
        System.out.println(task.validIPAddress("123.456.789.012")); // Neither
    }
}