package ZeroShot.gemini;
import java.util.Scanner;

public class Task113 {
    public static String concatenateStrings(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int numStrings = scanner.nextInt();
        scanner.nextLine(); 

        String[] strings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        String concatenatedString = concatenateStrings(strings);
        System.out.println("Concatenated string: " + concatenatedString);


        String[] test1 = {"Hello", ", ", "world", "!"};
        System.out.println(concatenateStrings(test1));
        String[] test2 = {"Java", "Python", "C++", "C"};
        System.out.println(concatenateStrings(test2));
        String[] test3 = {"", "", ""};
        System.out.println(concatenateStrings(test3));
        String[] test4 = {"Single"};
        System.out.println(concatenateStrings(test4));
        String[] test5 = {"Test", "1", "Test", "2"};
        System.out.println(concatenateStrings(test5));
    }
}