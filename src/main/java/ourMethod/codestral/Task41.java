package ourMethod.codestral;
public class Task41 {
    public static void processString(String input) {
        // No buffer overflow risk as String is a built-in type in Java
        // that can handle any size of input without buffer overflow
        System.out.println("Processed string: " + input);
    }

    public static void main(String[] args) {
        processString("Test case 1");
        processString("Test case 2 with longer input");
        // Add more test cases as needed
    }
}