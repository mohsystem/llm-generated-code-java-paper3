package ZeroShot.codestral;
public class Task71 {
    public static Integer convertToInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(convertToInteger(args[0]));
        System.out.println(convertToInteger(args[1]));
        System.out.println(convertToInteger(args[2]));
        System.out.println(convertToInteger(args[3]));
        System.out.println(convertToInteger(args[4]));
    }
}