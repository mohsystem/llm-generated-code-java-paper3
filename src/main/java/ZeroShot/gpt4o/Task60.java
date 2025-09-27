package ZeroShot.gpt4o;
public class Task60 {
    public static String expandedForm(int num) {
        StringBuilder result = new StringBuilder();
        int divisor = 10;
        while (num > 0) {
            int remainder = num % divisor;
            if (remainder > 0) {
                if (result.length() > 0) {
                    result.insert(0, " + ");
                }
                result.insert(0, remainder);
            }
            num -= remainder;
            divisor *= 10;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));    // Should return "10 + 2"
        System.out.println(expandedForm(42));    // Should return "40 + 2"
        System.out.println(expandedForm(70304)); // Should return "70000 + 300 + 4"
        System.out.println(expandedForm(5));     // Should return "5"
        System.out.println(expandedForm(5600));  // Should return "5000 + 600"
    }
}