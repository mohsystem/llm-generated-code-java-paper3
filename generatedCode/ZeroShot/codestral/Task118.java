package ZeroShot.codestral;
public class Task118 {
    public static boolean isValidIP(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            int i = Integer.parseInt(part);
            if ((i < 0) || (i > 255)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {"192.168.1.1", "256.168.1.1", "192.168.1", "192.168.1.abc"};
        for (String ip : testCases) {
            System.out.println(ip + " is valid: " + isValidIP(ip));
        }
    }
}