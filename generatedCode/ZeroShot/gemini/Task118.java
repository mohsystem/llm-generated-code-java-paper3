package ZeroShot.gemini;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task118 {
    public boolean isValidIP(String ip) {
        String zeroTo255 = "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])";
        String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Task118 task = new Task118();
        System.out.println(task.isValidIP("0.0.0.0")); // true
        System.out.println(task.isValidIP("255.255.255.255")); // true
        System.out.println(task.isValidIP("192.168.1.1")); // true
        System.out.println(task.isValidIP("256.256.256.256")); // false
        System.out.println(task.isValidIP("192.168.1.256")); // false

    }
}