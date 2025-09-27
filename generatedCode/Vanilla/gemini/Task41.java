package Vanilla.gemini;
import java.util.Scanner;

public class Task41 {

    public static String processString(String input) {
        if (input == null) {
            return null;
        }
        return input.trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(processString(scanner.nextLine()));
        System.out.println(processString("   leading spaces"));
        System.out.println(processString("trailing spaces   "));
        System.out.println(processString("   both spaces   "));
        System.out.println(processString(null));


        scanner.close();


    }
}