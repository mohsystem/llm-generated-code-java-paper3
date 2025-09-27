package Vanilla.claude;

class Task118 {
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
                int value = Integer.parseInt(part);
                if (value < 0 || value > 255) {
                    return false;
                }
                if (part.length() > 1 && part.startsWith("0")) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        String[] testIPs = {
            "192.168.1.1",
            "256.1.2.3",
            "1.1.1.1",
            "01.02.03.04",
            "192.168.001.1"
        };

        for (String ip : testIPs) {
            System.out.println("IP: " + ip + " is " + (validateIP(ip) ? "valid" : "invalid"));
        }
    }
}
