package CoT.openai;
import java.util.Scanner;

public class Task44 {
    public static String processInput(String input) {
        if (input == null || input.isEmpty()) {
            return "Invalid input!";
        }
        return "Processed: " + input.trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] testInputs = {"Hello", "  World  ", "", null, "Java"};
        for (String input : testInputs) {
            System.out.println(processInput(input));
        }
    }
}