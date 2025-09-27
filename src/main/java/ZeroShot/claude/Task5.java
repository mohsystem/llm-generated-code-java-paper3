package ZeroShot.claude;

public class Task5 {
    public static int persistence(long num) {
        int count = 0;
        
        while (num >= 10) {
            long product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            num = product;
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println("Test Case 1: " + persistence(39));  // Expected: 3
        System.out.println("Test Case 2: " + persistence(999)); // Expected: 4
        System.out.println("Test Case 3: " + persistence(4));   // Expected: 0
        System.out.println("Test Case 4: " + persistence(25));  // Expected: 2
        System.out.println("Test Case 5: " + persistence(777)); // Expected: 4
    }
}
