package ourMethod.llama31;
public class Task60 {
    public static String expandedForm(int num) {
        String strNum = String.valueOf(num);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strNum.length(); i++) {
            int digit = strNum.charAt(i) - '0';
            if (digit != 0) {
                if (result.length() > 0) {
                    result.append(" + ");
                }
                result.append(digit);
                for (int j = 0; j < strNum.length() - i - 1; j++) {
                    result.append("0");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));   // Should return "10 + 2"
        System.out.println(expandedForm(42));   // Should return "40 + 2"
        System.out.println(expandedForm(70304)); // Should return "70000 + 300 + 4"
    }
}