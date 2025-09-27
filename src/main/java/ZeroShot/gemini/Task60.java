package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Task60 {
    public static String expandedForm(int num) {
        List<String> parts = new ArrayList<>();
        int divisor = 1;
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0) {
                parts.add(String.valueOf(digit * divisor));
            }
            num /= 10;
            divisor *= 10;
        }
        Collections.reverse(parts);
        return String.join(" + ", parts);
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12)); // Output: 10 + 2
        System.out.println(expandedForm(42)); // Output: 40 + 2
        System.out.println(expandedForm(70304)); // Output: 70000 + 300 + 4
        System.out.println(expandedForm(800)); // Output: 800
        System.out.println(expandedForm(10203)); // Output: 10000 + 200 + 3
    }
}