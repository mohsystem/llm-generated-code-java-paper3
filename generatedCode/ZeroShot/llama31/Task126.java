package ZeroShot.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task126 {
    public static void main(String[] args) {
        Map<String, String> redirects = new HashMap<>();
        redirects.put("one", "https://example.com/one");
        redirects.put("two", "https://example.com/two");
        redirects.put("three", "https://example.com/three");

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter your code here: ");
            String code = scanner.nextLine().trim().toLowerCase();
            if (redirects.containsKey(code)) {
                System.out.println("Redirecting to: " + redirects.get(code));
            } else {
                System.out.println("Invalid code");
            }
        }
    }
}