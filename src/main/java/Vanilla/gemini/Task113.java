package Vanilla.gemini;
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

        System.out.println(concatenateStrings(new String[]{"Hello", ", ", "world", "!"}));
        System.out.println(concatenateStrings(new String[]{"Java", " ", "is", " ", "fun"}));
        System.out.println(concatenateStrings(new String[]{"This", " ", "is", " ", "a", " ", "test"}));
        System.out.println(concatenateStrings(new String[]{"Empty", ""}));
        System.out.println(concatenateStrings(new String[]{"Single"}));


    }
}