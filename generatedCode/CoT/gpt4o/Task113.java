package CoT.openai;
import java.util.Scanner;

public class Task113 {

    public static String concatenateStrings(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of strings to concatenate:");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter string " + (i + 1) + ":");
            strings[i] = scanner.nextLine();
        }

        String result = concatenateStrings(strings);
        System.out.println("Concatenated result: " + result);
        
        // Test cases
        System.out.println(concatenateStrings("Hello", "World"));
        System.out.println(concatenateStrings("Java", " ", "Programming"));
        System.out.println(concatenateStrings("Secure", "Coding"));
        System.out.println(concatenateStrings("Chain", "-", "Of", "-", "Through"));
        System.out.println(concatenateStrings("Test", "123"));
        
        scanner.close();
    }
}