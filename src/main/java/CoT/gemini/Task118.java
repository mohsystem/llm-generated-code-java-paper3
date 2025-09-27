package CoT.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task118 {

    public boolean isValidIP(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        String regex = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();

    }

    public static void main(String[] args) {
        Task118 task118 = new Task118();
        System.out.println(task118.isValidIP("0.0.0.0")); // true
        System.out.println(task118.isValidIP("255.255.255.255")); // true
        System.out.println(task118.isValidIP("192.168.1.1")); // true
        System.out.println(task118.isValidIP("256.256.256.256")); // false
        System.out.println(task118.isValidIP("192.168.1.256")); // false

    }
}