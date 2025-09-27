package ourMethod.claude;

public class Task60 {
    public static String expandedForm(int num) {
        if (num <= 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        int position = 1;
        
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0) {
                if (result.length() > 0) {
                    result.insert(0, " + ");
                }
                result.insert(0, digit * position);
            }
            num /= 10;
            position *= 10;
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(expandedForm(12));  // "10 + 2"
        System.out.println(expandedForm(42));  // "40 + 2"
        System.out.println(expandedForm(70304));  // "70000 + 300 + 4"
        System.out.println(expandedForm(4982));  // "4000 + 900 + 80 + 2"
        System.out.println(expandedForm(1));  // "1"
    }
}
