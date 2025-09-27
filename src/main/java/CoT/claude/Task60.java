package CoT.claude;

public class Task60 {
    public static String expandedForm(long num) {
        StringBuilder result = new StringBuilder();
        String numStr = String.valueOf(num);
        
        for(int i = 0; i < numStr.length(); i++) {
            if(numStr.charAt(i) != '0') {
                if(result.length() > 0) {
                    result.append(" + ");
                }
                result.append(numStr.charAt(i));
                for(int j = 0; j < numStr.length()-1-i; j++) {
                    result.append("0");
                }
            }
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
