package CoT.codestral;
public class Task114 {
    public static void main(String[] args) {
        String str1 = "Hello, ";
        String str2 = "World!";
        String str3 = str1 + str2; // concatenation
        String str4 = str1; // copying
        str4 = str4.replace("Hello", "Hi"); // manipulation
        System.out.println(str3);
        System.out.println(str4);
    }
}