package ourMethod.claude;

public class Task59 {
    public static String accum(String input) {
        if (input == null) {
            return "";
        }
        
        if (!input.matches("^[a-zA-Z]*$")) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            result.append(Character.toUpperCase(c));
            
            for (int j = 0; j < i; j++) {
                result.append(Character.toLowerCase(c));
            }
            
            if (i < input.length() - 1) {
                result.append('-');
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(accum("abcd"));      // "A-Bb-Ccc-Dddd"
        System.out.println(accum("RqaEzty"));   // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        System.out.println(accum("cwAt"));      // "C-Ww-Aaa-Tttt"
        System.out.println(accum(""));          // ""
        System.out.println(accum("Z"));         // "Z"
    }
}
