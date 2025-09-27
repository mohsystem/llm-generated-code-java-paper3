package Vanilla.codestral;
public class Task60 {
    public static String expandedForm(int num) {
        StringBuilder sb = new StringBuilder();
        int[] digits = {10000, 1000, 100, 10, 1};
        for (int digit : digits) {
            int count = num / digit;
            if (count > 0) {
                if (sb.length() > 0) {
                    sb.append(" + ");
                }
                sb.append(count * digit);
                num -= count * digit;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12)); // Should return "10 + 2"
        System.out.println(expandedForm(42)); // Should return "40 + 2"
        System.out.println(expandedForm(70304)); // Should return "70000 + 300 + 4"
    }
}