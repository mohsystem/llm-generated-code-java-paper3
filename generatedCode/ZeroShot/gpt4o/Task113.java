package ZeroShot.gpt4o;
import java.util.Scanner;

public class Task113 {
    public static String concatenateStrings(String... strings) {
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 strings:");
        String[] inputs = new String[5];
        for (int i = 0; i < 5; i++) {
            inputs[i] = scanner.nextLine();
        }
        scanner.close();
        
        String result = concatenateStrings(inputs);
        System.out.println("Concatenated result: " + result);
    }
}