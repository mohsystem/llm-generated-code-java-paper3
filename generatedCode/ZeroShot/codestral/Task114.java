package ZeroShot.codestral;
public class Task114 {
    public static void main(String[] args) {
        test("Hello", " World");
    }

    public static void test(String str1, String str2) {
        // Copying a string
        String str3 = new String(str1);
        System.out.println("Copied string: " + str3);

        // Concatenating two strings
        String str4 = str1.concat(str2);
        System.out.println("Concatenated string: " + str4);

        // Manipulating a string
        String str5 = str1.replace('l', 'm');
        System.out.println("Manipulated string: " + str5);
    }
}