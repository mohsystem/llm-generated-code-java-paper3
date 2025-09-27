package ZeroShot.llama31;
public class Task114 {
    public static void main(String[] args) {
        // Test cases
        String str1 = "Hello";
        String str2 = "World";
        String str3 = copyString(str1);
        String str4 = concatenateStrings(str1, str2);
        String str5 = manipulateString(str1, 'l', 'x');

        System.out.println("Copied String: " + str3);
        System.out.println("Concatenated String: " + str4);
        System.out.println("Manipulated String: " + str5);

        str1 = "this is init";
        str2 = " added now";
        str3 = copyString(str1);
        str4 = concatenateStrings(str1, str2);
        str5 = manipulateString(str1, 'i', 'e');

        System.out.println("Copied String: " + str3);
        System.out.println("Concatenated String: " + str4);
        System.out.println("Manipulated String: " + str5);

        str1 = "test string";
        str2 = " more text";
        str3 = copyString(str1);
        str4 = concatenateStrings(str1, str2);
        str5 = manipulateString(str1, 't', 'd');

        System.out.println("Copied String: " + str3);
        System.out.println("Concatenated String: " + str4);
        System.out.println("Manipulated String: " + str5);

        str1 = "sample text";
        str2 = " additional content";
        str3 = copyString(str1);
        str4 = concatenateStrings(str1, str2);
        str5 = manipulateString(str1, 's', 'r');

        System.out.println("Copied String: " + str3);
        System.out.println("Concatenated String: " + str4);
        System.out.println("Manipulated String: " + str5);

        str1 = "final test";
        str2 = " last check";
        str3 = copyString(str1);
        str4 = concatenateStrings(str1, str2);
        str5 = manipulateString(str1, 'f', 'l');

        System.out.println("Copied String: " + str3);
        System.out.println("Concatenated String: " + str4);
        System.out.println("Manipulated String: " + str5);
    }

    public static String copyString(String str) {
        return new String(str);
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    public static String manipulateString(String str, char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }
}