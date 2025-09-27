package Vanilla.llama31;
public class Task60 {
    public static String expandedForm(int num) {
        String numStr = String.valueOf(num);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            if (digit != 0) {
                if (result.length() > 0) result.append(" + ");
                result.append(digit * (int) Math.pow(10, numStr.length() - 1 - i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));   // Should return "10 + 2"
        System.out.println(expandedForm(42));   // Should return "40 + 2"
        System.out.println(expandedForm(70304)); // Should return "70000 + 300 + 4"
        System.out.println(expandedForm(100));  // Should return "100"
        System.out.println(expandedForm(12345)); // Should return "10000 + 2000 + 300 + 40 + 5"
    }
}