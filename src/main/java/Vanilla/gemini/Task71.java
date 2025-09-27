package Vanilla.gemini;
public class Task71 {
    public static int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1; // Or throw an exception, depending on desired behavior
        }
    }

    public static void main(String[] args) {
        System.out.println(stringToInt(args[0]));
        System.out.println(stringToInt("1234"));
        System.out.println(stringToInt("0"));
        System.out.println(stringToInt("-567"));
        System.out.println(stringToInt("abc"));


    }
}