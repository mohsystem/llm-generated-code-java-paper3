package Vanilla.gemini;
import java.util.Scanner;

public class Task98 {
    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Or throw an exception, depending on desired behavior
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(convertToInt("123"));
        System.out.println(convertToInt("456.7"));
        System.out.println(convertToInt("abc"));
        System.out.println(convertToInt("-789"));
        System.out.println(convertToInt("0"));


    }
}