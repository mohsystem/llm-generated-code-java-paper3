package ourMethod.codestral;
public class Task114 {
    public static void main(String[] args) {
        testStringOperations("Hello", "World");
    }

    public static void testStringOperations(String str1, String str2) {
        // Copying strings
        String str3 = new String(str1);
        System.out.println("Copied string: " + str3);

        // Concatenating strings
        String str4 = str1.concat(" ").concat(str2);
        System.out.println("Concatenated string: " + str4);

        // Manipulating strings
        String str5 = str4.toUpperCase();
        System.out.println("Uppercase string: " + str5);

        String str6 = str4.toLowerCase();
        System.out.println("Lowercase string: " + str6);

        String str7 = str4.replace(" ", "_");
        System.out.println("Manipulated string: " + str7);
    }
}