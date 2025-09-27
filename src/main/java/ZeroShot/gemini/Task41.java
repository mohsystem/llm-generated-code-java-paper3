package ZeroShot.gemini;
import java.util.Scanner;

public class Task41 {

    public static String processString(String input) {
        if (input == null) {
            return "";
        }
        char[] charArray = new char[input.length()];
        input.getChars(0, input.length(), charArray, 0);
        // Process charArray (e.g., convert to uppercase)
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = Character.toUpperCase(charArray[i]);
        }

        return new String(charArray);


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(processString(scanner.nextLine()));
         System.out.println(processString("hello"));
         System.out.println(processString("world"));
         System.out.println(processString("java"));
         System.out.println(processString("secure"));

    }
}