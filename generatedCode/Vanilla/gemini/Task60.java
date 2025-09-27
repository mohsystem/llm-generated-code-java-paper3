package Vanilla.gemini;
public class Task60 {

    public static String expandedForm(int num) {
        String result = "";
        String numStr = String.valueOf(num);
        int numLen = numStr.length();

        for (int i = 0; i < numLen; i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            if (digit > 0) {
                if (!result.isEmpty()) {
                    result += " + ";
                }
                result += digit * Math.pow(10, numLen - i - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12)); // "10 + 2"
        System.out.println(expandedForm(42)); // "40 + 2"
        System.out.println(expandedForm(70304)); // "70000 + 300 + 4"
        System.out.println(expandedForm(800)); // "800"
        System.out.println(expandedForm(10000000)); // "10000000"

    }
}