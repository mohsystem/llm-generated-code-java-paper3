package ZeroShot.gemini;
import java.util.Arrays;

public class Task71 {
    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Or throw an exception, depending on requirements
        }
    }

    public static void main(String[] args) {
        System.out.println(stringToInt(args[0]));
        System.out.println(stringToInt("12345"));
        System.out.println(stringToInt("0"));
        System.out.println(stringToInt("-987"));
        System.out.println(stringToInt("abc")); 
    }
}