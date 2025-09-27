package Vanilla.gemini;
import java.util.regex.*;

class Task118 {
    public static boolean isValidIP(String ip) {
        String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
        return Pattern.matches(regex, ip);
    }

    public static void main(String[] args) {
        System.out.println(isValidIP("0.0.0.0")); // true
        System.out.println(isValidIP("255.255.255.255")); // true
        System.out.println(isValidIP("1.2.3.4")); // true
        System.out.println(isValidIP("1.2.3.4.5")); // false
        System.out.println(isValidIP("256.1.2.3")); // false
    }

}