package Vanilla.claude;

public class Task182 {
    public static String cleanPhoneNumber(String phoneNumber) {
        String cleaned = phoneNumber.replaceAll("[^0-9]", "");
        
        if (cleaned.length() > 11 || cleaned.length() < 10)
            return null;
            
        if (cleaned.length() == 11) {
            if (cleaned.charAt(0) != '1')
                return null;
            cleaned = cleaned.substring(1);
        }
        
        if (cleaned.length() != 10)
            return null;
            
        if (cleaned.charAt(0) < '2')
            return null;
            
        if (cleaned.charAt(3) < '2') 
            return null;
            
        return cleaned;
    }
    
    public static void main(String[] args) {
        String[] tests = {
            "+1 (613)-995-0253",
            "613-995-0253",
            "1 613 995 0253",
            "613.995.0253",
            "123-456-7890"
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + cleanPhoneNumber(test));
        }
    }
}
