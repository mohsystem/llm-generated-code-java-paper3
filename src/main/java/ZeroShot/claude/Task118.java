package ZeroShot.claude;

public class Task118 {
    public static boolean isValidIP(String ipAddress) {
        if (ipAddress == null || ipAddress.isEmpty()) {
            return false;
        }
        
        String[] parts = ipAddress.split("\\\\.");
        if (parts.length != 4) {
            return false;
        }
        
        try {
            for (String part : parts) {
                if (part.length() > 1 && part.startsWith("0")) {
                    return false;
                }
                
                int value = Integer.parseInt(part);
                if (value < 0 || value > 255) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testIPs = {
            "192.168.1.1",
            "256.1.2.3",
            "1.1.1.1",
            "01.02.03.04",
            "192.168.001.1"
        };
        
        for (String ip : testIPs) {
            System.out.println(ip + " is " + (isValidIP(ip) ? "valid" : "invalid"));
        }
    }
}
