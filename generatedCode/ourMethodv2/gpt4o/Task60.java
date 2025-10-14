package ourMethodv2.gpt4o;
public class Task60 {
    public static String expandedForm(int num) {
        StringBuilder result = new StringBuilder();
        int factor = 1;
        while (num > 0) {
            int remainder = num % 10;
            if (remainder != 0) {
                result.insert(0, (remainder * factor) + " + ");
            }
            num /= 10;
            factor *= 10;
        }
        return result.length() > 0 ? result.substring(0, result.length() - 3) : "";
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));    // "10 + 2"
        System.out.println(expandedForm(42));    // "40 + 2"
        System.out.println(expandedForm(70304)); // "70000 + 300 + 4"
        System.out.println(expandedForm(560));   // "500 + 60"
        System.out.println(expandedForm(9));     // "9"
    }
}