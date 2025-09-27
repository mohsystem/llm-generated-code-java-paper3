package Vanilla.codestral;
public class Task71 {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt(args[0]);
            System.out.println("Converted integer: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + args[0]);
        }
    }
}