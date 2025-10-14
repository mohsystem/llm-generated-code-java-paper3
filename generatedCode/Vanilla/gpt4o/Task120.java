package Vanilla.openai;
import java.util.Scanner;
import java.util.ArrayList;

public class Task120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<String>();
        
        System.out.println("Enter input to display on web page (type 'end' to finish): ");
        while (true) {
            String input = scanner.nextLine();
            if ("end".equalsIgnoreCase(input)) {
                break;
            }
            inputs.add(input);
        }
        
        for (String input : inputs) {
            System.out.println("<p>" + input + "</p>");
        }
        
        scanner.close();
    }
}