package CoT.gemini;
import java.util.Scanner;

public class Task41 {

    public static String processString(String input) {
        if (input == null) {
            return ""; 
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(processString("Test1"));
        System.out.println(processString("Test2"));
        System.out.println(processString("Test3"));
        System.out.println(processString("Test4"));
        System.out.println(processString(null));


        scanner.close();

    }
}