package CoT.gemini;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task60 {

    public static String expandedForm(int num) {
        List<String> parts = new ArrayList<>();
        int divisor = 1;

        while (num > 0) {
            int digit = num % 10;
            if (digit > 0) {
                parts.add(Integer.toString(digit * divisor));
            }
            num /= 10;
            divisor *= 10;
        }

        Collections.reverse(parts);
        return String.join(" + ", parts);
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12)); // Should return "10 + 2"
        System.out.println(expandedForm(42)); // Should return "40 + 2"
        System.out.println(expandedForm(70304)); // Should return "70000 + 300 + 4"
        System.out.println(expandedForm(800)); // Should return "800"
        System.out.println(expandedForm(1000000)); // Should return "1000000"
    }
}