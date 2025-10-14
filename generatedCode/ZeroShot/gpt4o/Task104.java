package ZeroShot.openai;
import java.util.Scanner;

public class Task104 {

    public static String handleInput(String input) {
        int bufferSize = 10;
        if (input.length() > bufferSize) {
            return input.substring(0, bufferSize);
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        String[] testInputs = {"short", "a bit longer", "this input is definitely too long"};
        for (String input : testInputs) {
            System.out.println("Processed input: " + handleInput(input));
        }
    }
}