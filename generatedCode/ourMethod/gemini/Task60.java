package ourMethod.gemini;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Task60 {
    public String expandedForm(int num) {
        if (num <= 0) {
            return "";
        }

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
        Task60 kata = new Task60();
        System.out.println(kata.expandedForm(12)); // Should return "10 + 2"
        System.out.println(kata.expandedForm(42)); // Should return "40 + 2"
        System.out.println(kata.expandedForm(70304)); // Should return "70000 + 300 + 4"
        System.out.println(kata.expandedForm(1000)); // Should return "1000"
        System.out.println(kata.expandedForm(9000000)); // Should return "9000000"

    }
}