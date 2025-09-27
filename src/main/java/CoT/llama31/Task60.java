package CoT.llama31;
public class Task60 {
    public static String expandedForm(int num) {
        String numStr = Integer.toString(num);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            if (digit != 0) {
                if (result.length() > 0) {
                    result.append(" + ");
                }
                result.append(digit);
                for (int j = numStr.length() - 1 - i; j > 0; j--) {
                    result.append('0');
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));   // Output: "10 + 2"
        System.out.println(expandedForm(42));  // Output: "40 + 2"
        System.out.println(expandedForm(70304)); // Output: "70000 + 300 + 4"
        System.out.println(expandedForm(100)); // Output: "100"
        System.out.println(expandedForm(12345)); // Output: "10000 + 2000 + 300 + 40 + 5"
    }
}