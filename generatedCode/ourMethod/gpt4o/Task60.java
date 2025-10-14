package ourMethod.openai;
public class Task60 {
    public static String expandedForm(int num) {
        StringBuilder result = new StringBuilder();
        int factor = 1;

        while (num > 0) {
            int remainder = num % 10;
            if (remainder != 0) {
                result.insert(0, remainder * factor + " + ");
            }
            num /= 10;
            factor *= 10;
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 3); // Remove the last " + "
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12)); // Should return "10 + 2"
        System.out.println(expandedForm(42)); // Should return "40 + 2"
        System.out.println(expandedForm(70304)); // Should return "70000 + 300 + 4"
        System.out.println(expandedForm(807)); // Should return "800 + 7"
        System.out.println(expandedForm(530)); // Should return "500 + 30"
    }
}