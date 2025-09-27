package ourMethod.codestral;
public class Task60 {
    public static String expandedForm(int num) {
        String result = "";
        for (int i = 10; i <= num; i *= 10) {
            int rem = num % i;
            num -= rem;
            if (rem > 0) {
                if (!result.isEmpty()) {
                    result = " + " + result;
                }
                result = rem + result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));  // Should return "10 + 2"
        System.out.println(expandedForm(42));  // Should return "40 + 2"
        System.out.println(expandedForm(70304));  // Should return "70000 + 300 + 4"
    }
}