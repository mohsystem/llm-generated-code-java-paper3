package ourMethodv2.gpt4o;
import java.util.Scanner;

public class Task113 {
    public static String concatenateStrings(String[] strings) {
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] testCases = new String[5];
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a string for test case " + (i + 1) + ":");
            testCases[i] = scanner.nextLine();
        }
        
        System.out.println("Concatenated result: " + concatenateStrings(testCases));
        
        scanner.close();
    }
}