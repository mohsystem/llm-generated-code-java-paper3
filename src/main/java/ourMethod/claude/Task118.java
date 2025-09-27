package ourMethod.claude;

public class Task118 {
    public static boolean validateIPAddress(String ipAddress) {
        if (ipAddress == null || ipAddress.isEmpty()) {
            return false;
        }

        // Split IP address into octets
        String[] octets = ipAddress.split("\\\\.");
        
        // Check if exactly 4 octets
        if (octets.length != 4) {
            return false;
        }

        try {
            // Validate each octet
            for (String octet : octets) {
                // Check for empty octets
                if (octet.isEmpty() || octet.length() > 3) {
                    return false;
                }
                
                // Check for leading zeros
                if (octet.length() > 1 && octet.startsWith("0")) {
                    return false;
                }

                // Parse and validate range
                int value = Integer.parseInt(octet);
                if (value < 0 || value > 255) {
                    return false; 
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testIPs = {
            "192.168.1.1",     // valid
            "256.1.2.3",       // invalid - first octet > 255
            "1.2.3.4.5",       // invalid - too many octets
            "192.168.001.1",   // invalid - leading zeros
            "192.168.1.1.",    // invalid - trailing dot
        };

        for (String ip : testIPs) {
            System.out.println("IP: " + ip + " is " + 
                (validateIPAddress(ip) ? "valid" : "invalid"));
        }
    }
}
