package ourMethod.claude;

public class Task32 {
    public static int calculateYears(double principal, double interest, double tax, double desired) {
        if (principal < 0 || interest < 0 || tax < 0 || desired < 0) {
            throw new IllegalArgumentException("Parameters cannot be negative");
        }
        if (principal > desired) {
            throw new IllegalArgumentException("Principal cannot be greater than desired amount");
        }
        if (principal == desired) {
            return 0;
        }
        
        int years = 0;
        double currentAmount = principal;
        
        while (currentAmount < desired) {
            double interestEarned = currentAmount * interest;
            double taxPaid = interestEarned * tax;
            currentAmount += (interestEarned - taxPaid);
            years++;
            
            if (years > Integer.MAX_VALUE - 1) {
                throw new ArithmeticException("Years calculation overflow");
            }
        }
        return years;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(calculateYears(1000.00, 0.05, 0.18, 1100.00));  // Expected: 3
        System.out.println(calculateYears(1000.00, 0.01625, 0.18, 1200.00));  // Expected: 14
        System.out.println(calculateYears(1000.00, 0.05, 0.18, 1000.00));  // Expected: 0
        System.out.println(calculateYears(100.00, 0.1, 0.1, 110.00));  // Expected: 2
        System.out.println(calculateYears(1000.00, 0.05, 0.14, 1100.00));  // Expected: 3
    }
}
