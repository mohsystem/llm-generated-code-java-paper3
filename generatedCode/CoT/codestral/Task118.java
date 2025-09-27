package CoT.codestral;
public class Task118 {
    public static boolean validateIP(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String s : parts) {
            int i;
            try {
                i = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }
            if (i < 0 || i > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] ips = {"192.168.0.1", "256.0.0.1", "192.168.0.abc", "192.168.0.1.2", "192.168.0.-1"};
        for (String ip : ips) {
            System.out.println(ip + " is valid: " + validateIP(ip));
        }
    }
}