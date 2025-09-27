package ourMethod.claude;

public class Task5 {
    public static int persistence(long num) {
        // Validate input
        if (num < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        
        int count = 0;
        
        // Continue while number has more than one digit
        while (num > 9) {
            long product = 1;
            
            // Multiply all digits
            while (num > 0) {
                product *= (num % 10);
                num /= 10;
                
                // Check for overflow
                if (product < 0) {
                    throw new ArithmeticException("Multiplication overflow occurred");
                }
            }
            
            num = product;
            count++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(persistence(39));    // Should output 3
        System.out.println(persistence(999));   // Should output 4
        System.out.println(persistence(4));     // Should output 0
        System.out.println(persistence(25));    // Should output 2
        System.out.println(persistence(777));   // Should output 4
    }
}
