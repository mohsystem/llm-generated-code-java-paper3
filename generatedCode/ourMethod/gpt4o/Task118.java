package ourMethod.openai;
public class Task118 {
    public static boolean validateIPAddress(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) return false;

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validateIPAddress("192.168.1.1")); // true
        System.out.println(validateIPAddress("255.255.255.255")); // true
        System.out.println(validateIPAddress("256.256.256.256")); // false
        System.out.println(validateIPAddress("123.045.067.089")); // false
        System.out.println(validateIPAddress("192.168.1")); // false
    }
}