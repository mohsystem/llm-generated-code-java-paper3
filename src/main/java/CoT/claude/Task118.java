package CoT.claude;

public class Task118 {
    public static boolean validateIP(String ipAddress) {
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
            "192.168.1.1",      // valid
            "256.1.2.3",        // invalid - first octet > 255
            "1.2.3.4.5",        // invalid - too many octets
            "192.168.001.1",    // invalid - leading zeros
            "192.168.1.1a"      // invalid - contains letters
        };
        
        for (String ip : testIPs) {
            System.out.println("IP: " + ip + " is " + 
                (validateIP(ip) ? "valid" : "invalid"));
        }
    }
}
