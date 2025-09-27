package ZeroShot.llama31;
public class Task60 {
    public static String expandedForm(int num) {
        String numStr = String.valueOf(num);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) != '0') {
                if (result.length() > 0) {
                    result.append(" + ");
                }
                result.append(numStr.charAt(i));
                for (int j = numStr.length() - 1; j > i; j--) {
                    result.append('0');
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));   // Should return "10 + 2"
        System.out.println(expandedForm(42));   // Should return "40 + 2"
        System.out.println(expandedForm(70304)); // Should return "70000 + 300 + 4"
        System.out.println(expandedForm(10203)); // Test case
        System.out.println(expandedForm(12345)); // Test case
    }
}