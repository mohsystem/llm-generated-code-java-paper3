package Vanilla.claude;

public class Task60 {
    public static String expandedForm(int num) {
        StringBuilder result = new StringBuilder();
        int multiplier = 1;
        
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0) {
                if (result.length() > 0) {
                    result.insert(0, " + ");
                }
                result.insert(0, digit * multiplier);
            }
            num /= 10;
            multiplier *= 10;
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));    // "10 + 2"
        System.out.println(expandedForm(42));    // "40 + 2"
        System.out.println(expandedForm(70304)); // "70000 + 300 + 4"
        System.out.println(expandedForm(4982));  // "4000 + 900 + 80 + 2"
        System.out.println(expandedForm(1000));  // "1000"
    }
}
