package ourMethod.gemini;
import java.util.Scanner;

public class Task41 {

    public static String processString(String input) {
        if (input == null) {
            return ""; 
        }

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            // Example processing: convert to uppercase
            sb.append(Character.toUpperCase(c));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(processString("hello"));
        System.out.println(processString("world"));
        System.out.println(processString("12345"));
        System.out.println(processString(""));
        System.out.println(processString(null));


        scanner.close();
    }
}