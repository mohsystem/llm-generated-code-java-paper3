package CoT.openai;
public class Task60 {
    public static String expandedForm(int num) {
        StringBuilder result = new StringBuilder();
        int placeValue = 1;
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0) {
                result.insert(0, (digit * placeValue) + " + ");
            }
            num /= 10;
            placeValue *= 10;
        }
        return result.substring(0, result.length() - 3);
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));    // Should return "10 + 2"
        System.out.println(expandedForm(42));    // Should return "40 + 2"
        System.out.println(expandedForm(70304)); // Should return "70000 + 300 + 4"
        System.out.println(expandedForm(5));     // Should return "5"
        System.out.println(expandedForm(1009));  // Should return "1000 + 9"
    }
}