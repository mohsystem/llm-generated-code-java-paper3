package CoT.codestral;
public class Task60 {
    public static String expandedForm(int num) {
        String result = "";
        int power = 1;
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0) {
                if (!result.isEmpty()) {
                    result = " + " + result;
                }
                result = digit * power + result;
            }
            num /= 10;
            power *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12)); // Should return "10 + 2"
        System.out.println(expandedForm(42)); // Should return "40 + 2"
        System.out.println(expandedForm(70304)); // Should return "70000 + 300 + 4"
    }
}