package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task104 {
    private static final int BUFFER_SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string: ");
        char[] buffer = new char[BUFFER_SIZE];
        int length = reader.read(buffer, 0, BUFFER_SIZE);
        if (length < 0) {
            System.out.println("No input was provided.");
            return;
        }
        String input = new String(buffer, 0, length);
        System.out.println("You entered: " + input);
    }
}