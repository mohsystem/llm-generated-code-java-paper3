package ourMethod.gemini;
import java.util.Arrays;

public class Task114 {

    public static String copyString(String str) {
        return new String(str);
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }


    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }



    public static void main(String[] args) {
        String test1 = "Hello";
        String copy = copyString(test1);
        System.out.println("Copy: " + copy);


        String test2_1 = "Hello";
        String test2_2 = "World";
        String concatenated = concatenateStrings(test2_1, test2_2);
        System.out.println("Concatenated: " + concatenated);

        String test3 = "Reverse";
        String reversed = reverseString(test3);
        System.out.println("Reversed: " + reversed);


        String test4 = "uppercase";
        String upper = toUpperCase(test4);
        System.out.println("Uppercase: " + upper);


        String test5 = "LOWERCASE";
        String lower = toLowerCase(test5);
        System.out.println("Lowercase: " + lower);

    }
}